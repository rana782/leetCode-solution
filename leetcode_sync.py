#!/usr/bin/env python3
"""
leetcode_sync.py

- Fetches all LeetCode submissions (paginated).
- Writes accepted submissions into folders named after problem slug.
- Commits each submission file with original LeetCode timestamp (GIT_AUTHOR_DATE/GIT_COMMITTER_DATE).
- Keeps a small state file (.leetcode_sync_state.json) so runs can resume.
Designed for running inside GitHub Actions (or locally).
Env:
  - LEETCODE_SESSION (required) -> LeetCode session cookie (set in GitHub Secrets)
  - REPO_PATH (optional) -> path to repo (defaults to current working dir)
  - BRANCH (optional) -> branch to push to (defaults to 'main')
"""
import os
import sys
import time
import json
import requests
import subprocess
from pathlib import Path
from datetime import datetime, timezone

LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")
REPO_PATH = Path(os.environ.get("REPO_PATH", os.getcwd()))
BRANCH = os.environ.get("BRANCH", "main")

if not LEETCODE_SESSION:
    print("ERROR: LEETCODE_SESSION environment variable is not set. Exiting.")
    sys.exit(1)

if not (REPO_PATH.exists() and (REPO_PATH / ".git").exists()):
    print(f"ERROR: REPO_PATH {REPO_PATH} not found or not a git repository.")
    sys.exit(1)

STATE_FILE = REPO_PATH / ".leetcode_sync_state.json"

# language -> extension mapping (expand if needed)
EXT_MAP = {
    "cpp": "cpp", "c++": "cpp", "java": "java", "python": "py", "python3": "py",
    "c": "c", "c#": "cs", "csharp": "cs", "javascript": "js", "ruby": "rb",
    "swift": "swift", "go": "go", "rust": "rs", "kotlin": "kt", "scala": "scala",
    "php": "php",
}

session = requests.Session()
session.cookies.set("LEETCODE_SESSION", LEETCODE_SESSION, domain=".leetcode.com")
session.headers.update({"User-Agent": "github-action-leetcode-sync/1.0", "Referer": "https://leetcode.com"})

API_BASE = "https://leetcode.com/api/submissions/"

def run_git(args, env=None):
    full_env = os.environ.copy()
    if env:
        full_env.update(env)
    proc = subprocess.run(["git"] + args, cwd=str(REPO_PATH), env=full_env, text=True,
                          stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    if proc.returncode != 0:
        print("Git command failed:", proc.returncode)
        print("stdout:", proc.stdout)
        print("stderr:", proc.stderr)
        raise SystemExit(proc.returncode)
    return proc.stdout.strip()

def load_state():
    if STATE_FILE.exists():
        try:
            return json.loads(STATE_FILE.read_text(encoding="utf-8"))
        except Exception:
            return {}
    return {}

def save_state(state):
    STATE_FILE.write_text(json.dumps(state, indent=2), encoding="utf-8")

def safe_filename(s: str) -> str:
    return "".join(c if c.isalnum() or c in "-_." else "_" for c in (s or ""))

def fetch_all_submissions(limit=50, sleep_between=0.2):
    subs = []
    offset = 0
    while True:
        url = f"{API_BASE}?offset={offset}&limit={limit}"
        r = session.get(url, timeout=30)
        if r.status_code != 200:
            print("Failed to fetch submissions:", r.status_code)
            print("Response snippet:", r.text[:400])
            break
        data = r.json()
        batch = data.get("submissions_dump") or data.get("submissions") or []
        if not batch:
            break
        subs.extend(batch)
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

    # Commit oldest first so history is chronological
    for sub in reversed(subs):
        sid = str(sub.get("id") or sub.get("submission_id") or "")
        if sid in processed:
            continue
        try:
            changed = write_and_commit(sub)
            # mark processed even if we didn't create a file (to avoid repeat)
            state.setdefault("processed_ids", {})[sid] = {
                "title": sub.get("title"),
                "ts": sub.get("timestamp") or sub.get("time")
            }
            save_state(state)
            processed.add(sid)
        except Exception as e:
            print("Error processing submission id", sid, "-", e)
            save_state(state)
            raise

    print("All done. Now pushing changes to branch:", BRANCH)
    try:
        run_git(["push", "origin", BRANCH])
        print("Push successful.")
    except Exception as e:
        print("Push failed:", e)

if __name__ == "__main__":
    main()
