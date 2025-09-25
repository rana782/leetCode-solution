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

def fetch_all_submissions(limit=1000, sleep_between=0.25, max_retries=3):
    """
    Fetch all submissions using REST endpoint with paging.
    Default limit=1000 (large) so most accounts get everything in one call.
    Falls back to paging if server still sends < limit per page.
    """
    subs = []
    offset = 0
    while True:
        url = f"{API_BASE}?offset={offset}&limit={limit}"
        # retry loop for transient errors
        for attempt in range(1, max_retries + 1):
            try:
                r = session.get(url, timeout=30)
                break
            except Exception as e:
                print(f"Warning: request failed (attempt {attempt}/{max_retries}):", e)
                if attempt == max_retries:
                    raise
                time.sleep(1.0 * attempt)
        if r.status_code != 200:
            print("Failed to fetch submissions:", r.status_code)
            print("Response snippet:", r.text[:400])
            break
        data = r.json()
        batch = data.get("submissions_dump") or data.get("submissions") or []
        if not batch:
            # no more submissions
            break
        subs.extend(batch)
        print(f"Fetched page: offset={offset}, returned={len(batch)}")
        # If server returned fewer than requested, that often means we've reached the end.
        if len(batch) < limit:
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
