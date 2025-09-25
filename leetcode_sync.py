#!/usr/bin/env python3
"""
leetcode_sync.py
Reliable importer that:
 - Lists ALL submissions via REST (paginated)
 - Fetches full code via GraphQL submissionDetails
 - Keeps latest accepted per problem
 - Writes each problem to its own folder (slug/slug.ext)
 - Skips identical files
 - Creates one backdated commit per problem
 - Persists progress in .leetcode_sync_state.json for resume
Environment:
 - LEETCODE_SESSION (required) -> set as GitHub secret for Actions
 - REPO_PATH (optional) -> defaults to current workspace
 - BRANCH (optional) -> defaults to 'main'
"""

import os, sys, time, json, requests, subprocess, hashlib
from pathlib import Path
from datetime import datetime, timezone

# ---------- Config ----------
LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")
REPO_PATH = Path(os.environ.get("REPO_PATH", os.getcwd()))
BRANCH = os.environ.get("BRANCH", "main")
STATE_FILE = REPO_PATH / ".leetcode_sync_state.json"

if not LEETCODE_SESSION:
    print("ERROR: LEETCODE_SESSION not set. Exiting.")
    sys.exit(1)

if not (REPO_PATH.exists() and (REPO_PATH / ".git").exists()):
    print(f"ERROR: {REPO_PATH} is not a git repo.")
    sys.exit(1)

EXT_MAP = {
    "cpp": "cpp", "c++": "cpp", "java": "java", "python": "py", "python3": "py",
    "c": "c", "c#": "cs", "csharp": "cs", "javascript": "js", "typescript":"ts",
    "ruby": "rb", "swift":"swift", "go":"go", "rust":"rs", "kotlin":"kt",
    "scala":"scala", "php":"php"
}

session = requests.Session()
session.cookies.set("LEETCODE_SESSION", LEETCODE_SESSION, domain=".leetcode.com")
session.headers.update({"User-Agent": "leetcode-sync-script/1.0", "Referer": "https://leetcode.com"})

# ---------- helpers ----------
def run_git(args, env=None):
    env_all = os.environ.copy()
    if env:
        env_all.update(env)
    res = subprocess.run(["git"] + args, cwd=str(REPO_PATH), env=env_all,
                         text=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    if res.returncode != 0:
        print("Git error:", res.returncode)
        print(res.stdout, res.stderr)
        raise SystemExit(res.returncode)
    return res.stdout.strip()

def safe_filename(s):
    return "".join(c if c.isalnum() or c in "-_." else "_" for c in (s or ""))

def to_int_ts(x):
    if x is None:
        return 0
    try:
        return int(x)
    except Exception:
        try:
            return int(float(str(x)))
        except Exception:
            return 0

def file_sha1_text(text):
    h = hashlib.sha1()
    h.update(text.encode("utf-8"))
    return h.hexdigest()

def file_exists_and_same(path: Path, text: str) -> bool:
    if not path.exists():
        return False
    try:
        existing = path.read_text(encoding="utf-8")
    except Exception:
        return False
    return file_sha1_text(existing) == file_sha1_text(text)

def load_state():
    if STATE_FILE.exists():
        try:
            return json.loads(STATE_FILE.read_text(encoding="utf-8"))
        except Exception:
            return {}
    return {}

def save_state(state):
    STATE_FILE.write_text(json.dumps(state, indent=2), encoding="utf-8")

# ---------- REST listing (reliable paging) ----------
def fetch_all_submissions_rest(limit=20, sleep_between=0.2):
    """
    Use REST endpoint to page through all submissions.
    limit: items per page (server may enforce a cap; default 20 is safe)
    Returns list of submission dicts (metadata) in chronological order returned by API.
    """
    subs = []
    offset = 0
    while True:
        url = f"https://leetcode.com/api/submissions/?offset={offset}&limit={limit}"
        try:
            r = session.get(url, timeout=30)
        except Exception as e:
            print("REST request failed:", e)
            break
        if r.status_code != 200:
            print("REST: non-200 response:", r.status_code, r.text[:400])
            break
        data = r.json()
        batch = data.get("submissions_dump") or data.get("submissions") or []
        if not batch:
            break
        subs.extend(batch)
        print(f"REST: Fetched page offset={offset}, returned={len(batch)}")
        # if returned less than limit, likely end; otherwise increment offset
        if len(batch) < limit:
            break
        offset += limit
        time.sleep(sleep_between)
    return subs

# ---------- GraphQL details (code) ----------
def graphql_post(query, variables, max_retries=3):
    """Send GraphQL query with CSRF header handling and retry."""
    try:
        session.get("https://leetcode.com", timeout=10)
    except Exception:
        pass
    csrftoken = session.cookies.get("csrftoken") or ""
    headers = {
        "Referer": "https://leetcode.com",
        "X-Requested-With": "XMLHttpRequest",
        "User-Agent": session.headers.get("User-Agent", "leetcode-sync"),
    }
    if csrftoken:
        headers["X-CSRFToken"] = csrftoken
    for attempt in range(1, max_retries+1):
        try:
            r = session.post("https://leetcode.com/graphql", json={"query": query, "variables": variables}, headers=headers, timeout=30)
            if r.status_code == 200:
                return r.json()
            # On some 4xx errors, show snippet and break to allow fallback
            print("GraphQL status:", r.status_code, r.text[:300])
        except Exception as e:
            print("GraphQL request error:", e)
        time.sleep(attempt * 0.5)
    return None

def fetch_submission_code_graphql(sub_id):
    """
    Fetch submissionDetails for a given submission id.
    The field 'lang' in submissionDetails may be an object => request lang { name }.
    """
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
        print("Invalid submission id:", sub_id)
        return None
    body = graphql_post(gql, {"submissionId": sid})
    if not body:
        return None
    details = body.get("data", {}).get("submissionDetails", {})
    if not details:
        return None
    # flatten lang if object
    lang_field = details.get("lang")
    if isinstance(lang_field, dict):
        details["lang"] = lang_field.get("name") or ""
    details["timestamp"] = to_int_ts(details.get("timestamp"))
    return details

# ---------- Top-level flow ----------
def main():
    state = load_state()
    processed_ids = set(state.get("processed_ids", []))

    # 1) Get all submissions via REST (this will page until done)
    print("Fetching submissions via REST...")
    all_subs = fetch_all_submissions_rest(limit=20, sleep_between=0.25)
    print("Total submissions returned by REST:", len(all_subs))

    if not all_subs:
        print("No submissions found. Exiting.")
        return

    # 2) Build map latest accepted per problem (use timestamp ints)
    latest = {}
    for s in all_subs:
        status = (s.get("status_display") or s.get("status") or s.get("statusDisplay") or "").lower()
        # accept various keys
        if "accepted" not in status and not status.startswith("ac"):
            continue
        slug = s.get("title_slug") or s.get("titleSlug") or s.get("title") or ""
        ts = to_int_ts(s.get("timestamp") or s.get("time") or s.get("submission_time"))
        if not slug or ts == 0:
            continue
        prev = latest.get(slug)
        if prev is None or ts > to_int_ts(prev.get("timestamp") or prev.get("time") or 0):
            # normalize fields we will use
            item = {
                "id": s.get("id") or s.get("submission_id") or s.get("submissionId"),
                "title": s.get("title") or s.get("question_title") or slug,
                "titleSlug": slug,
                "timestamp": ts,
                "lang_name": s.get("lang") or s.get("language") or ""
            }
            latest[slug] = item

    print("Problems solved (unique):", len(latest))

    created = 0
    # 3) For each latest problem, fetch code and commit if needed (skip if processed)
    for slug, meta in latest.items():
        sid = meta.get("id")
        if not sid:
            print("Skipping", slug, "- no submission id")
            continue
        # resume/skip: if we've already processed this exact submission id, skip
        if str(sid) in processed_ids:
            continue

        details = fetch_submission_code_graphql(sid)
        if not details or not details.get("code"):
            print("No code for", slug, "submission", sid)
            # mark as processed to avoid retry loops? we won't mark so we can retry later
            continue

        code = details["code"]
        lang = (details.get("lang") or meta.get("lang_name") or "").lower()
        ext = EXT_MAP.get(lang, "txt")
        ts = to_int_ts(details.get("timestamp") or meta.get("timestamp"))
        if ts == 0:
            print("Skipping", slug, "because timestamp missing")
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

        if file_exists_and_same(file_path, new_content):
            # mark as processed and skip commit
            processed_ids.add(str(sid))
            state["processed_ids"] = list(processed_ids)
            save_state(state)
            continue

        # write file and commit backdated
        with open(file_path, "w", encoding="utf-8") as f:
            f.write(new_content)

        run_git(["add", str(file_path)])
        commit_msg = f"Latest LeetCode: {meta.get('title')} ({slug}) — solved on {iso}"
        env = {"GIT_AUTHOR_DATE": iso, "GIT_COMMITTER_DATE": iso}
        run_git(["commit", "-m", commit_msg], env=env)
        print("Committed", slug, "at", iso)
        created += 1

        # record processed id and save state to allow resume
        processed_ids.add(str(sid))
        state["processed_ids"] = list(processed_ids)
        save_state(state)

    print("Created commits:", created)
    if created > 0:
        run_git(["push", "origin", BRANCH])
        print("Push successful.")
    else:
        print("No new commits — all up to date.")

if __name__ == "__main__":
    main()
