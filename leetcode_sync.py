#!/usr/bin/env python3
"""
leetcode_sync.py
Fetch LeetCode submissions and commit them with original submission timestamps.
Designed to run inside GitHub Actions (or locally).

Environment:
  - LEETCODE_SESSION (required) -> LeetCode session cookie (set as a GitHub Secret)
  - REPO_PATH (optional) -> repo path (defaults to workspace)
  - BRANCH (optional) -> branch to push to (defaults to 'main')
"""
import os, sys, time, json, requests, subprocess
from pathlib import Path
from datetime import datetime, timezone

LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")
REPO_PATH = Path(os.environ.get("REPO_PATH", os.getcwd()))
BRANCH = os.environ.get("BRANCH", "main")

if not LEETCODE_SESSION:
    print("ERROR: LEETCODE_SESSION not set. Add it to repo secrets.")
    sys.exit(1)

if not (REPO_PATH.exists() and (REPO_PATH / ".git").exists()):
    print(f"ERROR: REPO_PATH {REPO_PATH} not found or not a git repo.")
    sys.exit(1)

STATE_FILE = REPO_PATH / ".leetcode_sync_state.json"

EXT_MAP = {
    "cpp":"cpp","c++":"cpp","java":"java","python":"py","python3":"py",
    "c":"c","c#":"cs","csharp":"cs","javascript":"js","ruby":"rb",
    "swift":"swift","go":"go","rust":"rs","kotlin":"kt","scala":"scala",
    "php":"php",
}

session = requests.Session()
session.cookies.set("LEETCODE_SESSION", LEETCODE_SESSION, domain=".leetcode.com")
session.headers.update({"User-Agent":"github-action-leetcode-sync/1.0","Referer":"https://leetcode.com"})

API_BASE = "https://leetcode.com/api/submissions/"

def run_git(args, env=None):
    full_env = os.environ.copy()
    if env:
        full_env.update(env)
    res = subprocess.run(["git"] + args, cwd=str(REPO_PATH), env=full_env,
                         text=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    if res.returncode != 0:
        print("Git failed:", res.returncode)
        print(res.stdout)
        print(res.stderr)
        raise SystemExit(res.returncode)
    return res.stdout.strip()

def load_state():
    if STATE_FILE.exists():
        try:
            return json.loads(STATE_FILE.read_text(encoding="utf-8"))
        except Exception:
            return {}
    return {}

def save_state(state):
    STATE_FILE.write_text(json.dumps(state, indent=2), encoding="utf-8")

def safe_filename(s):
    return "".join(c if c.isalnum() or c in "-_." else "_" for c in (s or ""))

def fetch_all_submissions(limit=200, sleep_between=0.25, max_retries=3):
    """
    GraphQL-first fetch with proper CSRF handling. Falls back to REST if GraphQL unavailable.
    - limit: page size for each request (200 default; increase to 500/1000 if desired)
    """
    # Ensure we have fresh site cookies (and csrftoken)
    try:
        # hit main page to populate csrf cookie
        session.get("https://leetcode.com", timeout=20)
    except Exception as e:
        print("Warning: initial GET to leetcode.com failed:", e)

    # extract csrf token if present
    csrftoken = session.cookies.get("csrftoken") or session.cookies.get("csrf-token") or session.cookies.get("CSRFToken")
    if csrftoken:
        print("Found csrftoken in cookies.")
    else:
        print("No csrftoken cookie found; we will still try GraphQL but may fail and fall back to REST.")

    # GraphQL query for submissionList
    gql = """
    query submissionList($offset: Int!, $limit: Int!) {
      submissionList(offset: $offset, limit: $limit) {
        submissions {
          id
          title
          titleSlug
          statusDisplay
          lang
          timestamp
          code
        }
        hasNext
      }
    }
    """

    def fetch_rest(limit, sleep_between, max_retries):
        subs = []
        offset = 0
        while True:
            url = f"{API_BASE}?offset={offset}&limit={limit}"
            for attempt in range(1, max_retries + 1):
                try:
                    r = session.get(url, timeout=30)
                    break
                except Exception as e:
                    print(f"REST request failed (attempt {attempt}/{max_retries}):", e)
                    if attempt == max_retries:
                        raise
                    time.sleep(1.0 * attempt)
            if r.status_code != 200:
                print("REST: Failed to fetch submissions:", r.status_code)
                print("Response snippet:", getattr(r, "text", "")[:400])
                break
            data = r.json()
            batch = data.get("submissions_dump") or data.get("submissions") or []
            if not batch:
                break
            subs.extend(batch)
            print(f"REST: Fetched page: offset={offset}, returned={len(batch)}")
            if len(batch) < limit:
                break
            offset += limit
            time.sleep(sleep_between)
        return subs

    # Try GraphQL with CSRF header
    subs = []
    offset = 0
    headers = {
        "Referer": "https://leetcode.com",
        "X-Requested-With": "XMLHttpRequest",
        "User-Agent": session.headers.get("User-Agent", "leetcode-sync"),
    }
    if csrftoken:
        headers["X-CSRFToken"] = csrftoken

    while True:
        payload = {"query": gql, "variables": {"offset": offset, "limit": limit}}
        r = None
        for attempt in range(1, max_retries + 1):
            try:
                r = session.post("https://leetcode.com/graphql", json=payload, timeout=30, headers=headers)
                break
            except Exception as e:
                print(f"GraphQL request failed (attempt {attempt}/{max_retries}):", e)
                if attempt == max_retries:
                    print("GraphQL failed repeatedly; falling back to REST.")
                    return fetch_rest(limit=limit, sleep_between=sleep_between, max_retries=max_retries)
                time.sleep(attempt * 0.8)

        if r is None:
            print("GraphQL: no response object; falling back to REST.")
            return fetch_rest(limit=limit, sleep_between=sleep_between, max_retries=max_retries)

        # If 4xx/5xx, show snippet and fall back to REST
        if r.status_code != 200:
            print("GraphQL: non-200 response; falling back to REST. status:", r.status_code)
            try:
                print("GraphQL response snippet:", r.text[:400])
            except Exception:
                pass
            return fetch_rest(limit=limit, sleep_between=sleep_between, max_retries=max_retries)

        body = r.json()
        batch = None
        try:
            batch = body.get("data", {}).get("submissionList", {}).get("submissions")
        except Exception:
            batch = None

        if not batch:
            # if GraphQL returned errors field, print and fallback
            if body.get("errors"):
                print("GraphQL returned errors; falling back to REST. errors:", body.get("errors"))
            else:
                print("GraphQL: no submissions in response; falling back to REST.")
            return fetch_rest(limit=limit, sleep_between=sleep_between, max_retries=max_retries)

        subs.extend(batch)
        print(f"GraphQL: Fetched page: offset={offset}, returned={len(batch)}")

        has_next = body.get("data", {}).get("submissionList", {}).get("hasNext")
        if has_next is False or len(batch) < limit:
            break

        offset += limit
        time.sleep(sleep_between)

    return subs




def write_and_commit(sub):
    status = (sub.get("status_display") or sub.get("status") or "").lower()
    if ("accepted" not in status) and (not status.startswith("ac")):
        return False

    title_slug = sub.get("title_slug") or sub.get("title") or f"problem_{sub.get('id','')}"
    title = sub.get("title") or title_slug
    lang = (sub.get("lang") or sub.get("language") or "").lower()
    ts = int(sub.get("timestamp") or sub.get("time") or 0)
    code = sub.get("code") or sub.get("submission_code") or ""
    if not code or ts == 0:
        return False

    ext = EXT_MAP.get(lang, "txt")
    prob_dir = REPO_PATH / safe_filename(title_slug)
    prob_dir.mkdir(parents=True, exist_ok=True)

    dt = datetime.fromtimestamp(ts, tz=timezone.utc)
    iso = dt.strftime("%Y-%m-%dT%H-%M-%SZ")
    sub_id = sub.get("id") or sub.get("submission_id") or ""
    filename = f"{iso}_{sub_id}_{lang}.{ext}"
    file_path = prob_dir / filename

    if file_path.exists():
        return False

    with open(file_path, "w", encoding="utf-8") as f:
        f.write(f"// LeetCode: {title} ({title_slug})\n")
        f.write(f"// Submission ID: {sub_id}\n")
        f.write(f"// Language: {lang}\n")
        f.write(f"// Timestamp (UTC): {iso}\n\n")
        f.write(code)

    commit_msg = f"Add LeetCode: {title} ({title_slug}) — solved on {iso}"
    env = {
        "GIT_AUTHOR_DATE": dt.strftime("%Y-%m-%dT%H:%M:%SZ"),
        "GIT_COMMITTER_DATE": dt.strftime("%Y-%m-%dT%H:%M:%SZ"),
    }
    run_git(["add", str(file_path)])
    run_git(["commit", "-m", commit_msg], env=env)
    print("Committed", file_path, "date", env["GIT_AUTHOR_DATE"])
    return True

def main():
    state = load_state()
    processed = set(state.get("processed_ids", {}).keys())

    print("Fetching submissions from LeetCode...")
    subs = fetch_all_submissions(limit=50, sleep_between=0.25)
    print("Total fetched:", len(subs))

    # oldest first so git history is chronological
    for sub in reversed(subs):
        sid = str(sub.get("id") or sub.get("submission_id") or "")
        if sid in processed:
            continue
        try:
            changed = write_and_commit(sub)
            state.setdefault("processed_ids", {})[sid] = {"title": sub.get("title"), "ts": sub.get("timestamp") or sub.get("time")}
            save_state(state)
            processed.add(sid)
        except Exception as e:
            print("Error processing submission id", sid, "-", e)
            save_state(state)
            raise

    print("Pushing changes to branch:", BRANCH)
    try:
        run_git(["push", "origin", BRANCH])
        print("Push successful.")
    except Exception as e:
        print("Push failed:", e)

if __name__ == "__main__":
    main()
