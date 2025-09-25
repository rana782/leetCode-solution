#!/usr/bin/env python3
"""
LeetCode sync with backdated commits credited to your GitHub account,
and forced commits (--allow-empty) when FORCE_RECOMMIT=1.

Behavior:
- Lists ALL submissions via REST (paginated, auto-retry on 403)
- Fetches full code via GraphQL submissionDetails
- Keeps latest accepted per problem
- Writes each problem to its own folder (slug/slug.ext)
- Creates one backdated commit per problem (author set via env)
- FORCE_RECOMMIT=1 will recreate commits even if file unchanged
- Persists processed submission IDs to .leetcode_sync_state.json
- Prints heatmap date for every commit in logs
"""

import os, sys, time, json, requests, subprocess, hashlib
from pathlib import Path
from datetime import datetime, timezone

# ---------- Config ----------
LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")
REPO_PATH = Path(os.environ.get("REPO_PATH", os.getcwd()))
BRANCH = os.environ.get("BRANCH", "main")
STATE_FILE = REPO_PATH / ".leetcode_sync_state.json"

AUTHOR_NAME = os.environ.get("AUTHOR_NAME") or os.environ.get("GITHUB_ACTOR") or "LeetCode Sync"
AUTHOR_EMAIL = os.environ.get("AUTHOR_EMAIL") or (os.environ.get("GITHUB_ACTOR", "") + "@users.noreply.github.com")
FORCE_RECOMMIT = os.environ.get("FORCE_RECOMMIT", "0") == "1"

if not LEETCODE_SESSION:
    print("ERROR: LEETCODE_SESSION not set. Exiting.")
    sys.exit(1)

if not (REPO_PATH.exists() and (REPO_PATH / ".git").exists()):
    print(f"ERROR: {REPO_PATH} is not a git repo.")
    sys.exit(1)

EXT_MAP = {
    "cpp":"cpp","c++":"cpp","java":"java","python":"py","python3":"py",
    "c":"c","c#":"cs","csharp":"cs","javascript":"js","typescript":"ts",
    "ruby":"rb","swift":"swift","go":"go","rust":"rs","kotlin":"kt",
    "scala":"scala","php":"php"
}

session = requests.Session()
session.cookies.set("LEETCODE_SESSION", LEETCODE_SESSION, domain=".leetcode.com")
session.headers.update({"User-Agent":"leetcode-sync-script/1.0","Referer":"https://leetcode.com"})

# ---------- Helpers ----------
def run_git(args, env=None):
    env_all = os.environ.copy()
    if env: env_all.update(env)
    res = subprocess.run(["git"] + args, cwd=str(REPO_PATH), env=env_all,
                         text=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    if res.returncode != 0:
        print("Git error:", res.returncode)
        print(res.stdout, res.stderr)
        raise SystemExit(res.returncode)
    return res.stdout.strip()

def safe_filename(s): return "".join(c if c.isalnum() or c in "-_." else "_" for c in (s or ""))

def to_int_ts(x):
    if x is None: return 0
    try: return int(x)
    except:
        try: return int(float(str(x)))
        except: return 0

def file_sha1_text(text):
    h = hashlib.sha1(); h.update(text.encode("utf-8")); return h.hexdigest()

def file_exists_and_same(path: Path, text: str) -> bool:
    if not path.exists(): return False
    try:
        existing = path.read_text(encoding="utf-8")
    except Exception:
        return False
    return file_sha1_text(existing) == file_sha1_text(text)

def load_state():
    if STATE_FILE.exists():
        try: return json.loads(STATE_FILE.read_text(encoding="utf-8"))
        except: return {}
    return {}

def save_state(state):
    STATE_FILE.write_text(json.dumps(state, indent=2), encoding="utf-8")

# ---------- REST listing (with resume / 403 retry) ----------
def fetch_all_submissions_rest(limit=20, max_retries=6, sleep_between=0.25):
    subs = []
    offset = 0
    while True:
        url = f"https://leetcode.com/api/submissions/?offset={offset}&limit={limit}"
        for attempt in range(1, max_retries + 1):
            try:
                r = session.get(url, timeout=30)
                if r.status_code == 200:
                    data = r.json()
                    batch = data.get("submissions_dump") or data.get("submissions") or []
                    if not batch:
                        return subs
                    subs.extend(batch)
                    print(f"REST: Fetched offset={offset}, returned={len(batch)}")
                    if len(batch) < limit:
                        return subs
                    offset += limit
                    time.sleep(sleep_between)
                    break
                elif r.status_code == 403:
                    wait = attempt * 5
                    print(f"REST: 403 at offset {offset}, retry {attempt}/{max_retries} in {wait}s...")
                    time.sleep(wait)
                else:
                    wait = attempt * 5
                    print(f"REST: {r.status_code} at offset {offset}, retry {attempt}/{max_retries} in {wait}s...")
                    time.sleep(wait)
            except Exception as e:
                wait = attempt * 5
                print(f"REST error at offset {offset}: {e}, retry {attempt}/{max_retries} in {wait}s...")
                time.sleep(wait)
        else:
            print(f"REST: failed after {max_retries} retries at offset={offset}, stopping.")
            return subs

# ---------- GraphQL details ----------
def graphql_post(query, variables, max_retries=3):
    try: session.get("https://leetcode.com", timeout=10)
    except: pass
    csrftoken = session.cookies.get("csrftoken") or ""
    headers = {
        "Referer":"https://leetcode.com",
        "X-Requested-With":"XMLHttpRequest",
        "User-Agent": session.headers.get("User-Agent","leetcode-sync")
    }
    if csrftoken:
        headers["X-CSRFToken"] = csrftoken
    for attempt in range(1, max_retries + 1):
        try:
            r = session.post("https://leetcode.com/graphql", json={"query": query, "variables": variables}, headers=headers, timeout=30)
            if r.status_code == 200:
                return r.json()
            print("GraphQL status:", r.status_code, r.text[:300])
        except Exception as e:
            print("GraphQL error:", e)
        time.sleep(attempt * 0.5)
    return None

def fetch_submission_code_graphql(sub_id):
    gql = """
    query submissionDetails($submissionId:Int!){
      submissionDetails(submissionId:$submissionId){
        id
        code
        lang { name }
        timestamp
      }
    }
    """
    try:
        sid = int(sub_id)
    except Exception:
        return None
    body = graphql_post(gql, {"submissionId": sid})
    if not body:
        return None
    details = body.get("data", {}).get("submissionDetails", {})
    if details:
        if isinstance(details.get("lang"), dict):
            details["lang"] = details["lang"].get("name") or ""
        details["timestamp"] = to_int_ts(details.get("timestamp"))
    return details

# ---------- Main ----------
def main():
    state = load_state()
    processed_ids = set(state.get("processed_ids", []))

    print("Fetching submissions via REST...")
    all_subs = fetch_all_submissions_rest(limit=20)
    print("Total submissions fetched:", len(all_subs))
    if not all_subs:
        print("No submissions found, exiting.")
        return

    # build latest accepted per problem
    latest = {}
    for s in all_subs:
        status = (s.get("status_display") or s.get("status") or s.get("statusDisplay") or "").lower()
        if "accepted" not in status and not status.startswith("ac"):
            continue
        slug = s.get("title_slug") or s.get("titleSlug") or s.get("title") or ""
        ts = to_int_ts(s.get("timestamp") or s.get("time") or s.get("submission_time"))
        if not slug or ts == 0:
            continue
        prev = latest.get(slug)
        if prev is None or ts > to_int_ts(prev.get("timestamp")):
            latest[slug] = {
                "id": s.get("id") or s.get("submission_id") or s.get("submissionId"),
                "title": s.get("title") or slug,
                "titleSlug": slug,
                "timestamp": ts,
                "lang_name": s.get("lang") or s.get("language") or ""
            }

    print("Problems solved (unique):", len(latest))

    created = 0
    for slug, meta in latest.items():
        sid = meta.get("id")
        if not sid:
            continue

        details = fetch_submission_code_graphql(sid)
        if not details or not details.get("code"):
            continue

        code = details["code"]
        lang = (details.get("lang") or meta.get("lang_name") or "").lower()
        ext = EXT_MAP.get(lang, "txt")
        ts = to_int_ts(details.get("timestamp") or meta.get("timestamp"))
        if ts == 0:
            continue

        dt = datetime.fromtimestamp(ts, tz=timezone.utc)
        iso = dt.strftime("%Y-%m-%dT%H:%M:%SZ")

        folder = REPO_PATH / safe_filename(slug)
        folder.mkdir(parents=True, exist_ok=True)
        file_path = folder / f"{safe_filename(slug)}.{ext}"

        new_content = (
            f"// LeetCode: {meta.get('title')} ({slug})\n"
            f"// Submission ID: {sid}\n"
            f"// Language: {lang}\n"
            f"// Timestamp (UTC): {iso}\n\n"
            f"{code}"
        )

        if not FORCE_RECOMMIT and file_exists_and_same(file_path, new_content):
            processed_ids.add(str(sid))
            state["processed_ids"] = list(processed_ids)
            save_state(state)
            continue

        # Write file
        file_path.write_text(new_content, encoding="utf-8")

        run_git(["add", str(file_path)])

        env = {
            "GIT_AUTHOR_DATE": iso,
            "GIT_COMMITTER_DATE": iso,
            "GIT_AUTHOR_NAME": AUTHOR_NAME,
            "GIT_AUTHOR_EMAIL": AUTHOR_EMAIL,
            "GIT_COMMITTER_NAME": AUTHOR_NAME,
            "GIT_COMMITTER_EMAIL": AUTHOR_EMAIL
        }

        commit_msg = f"LeetCode: {meta.get('title')} ({slug}) — solved on {iso}"

        if FORCE_RECOMMIT:
            # Force commit even if identical (heatmap backfill)
            run_git(["commit", "--allow-empty", "-m", commit_msg], env=env)
            print(f"Forced commit for {slug} at {iso} (heatmap date)")
        else:
            run_git(["commit", "-m", commit_msg], env=env)
            print(f"Committed {slug} at {iso}")

        created += 1
        processed_ids.add(str(sid))
        state["processed_ids"] = list(processed_ids)
        save_state(state)

    print("Created commits:", created)
    if created > 0:
        run_git(["push", "origin", BRANCH])
        print("Push successful.")
    else:
        print("No new commits.")

if __name__ == "__main__":
    main()
