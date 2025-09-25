#!/usr/bin/env python3
"""
leetcode_sync.py
Fetch ALL LeetCode submissions (using GraphQL) and commit them with original timestamps.

Steps:
- Uses GraphQL `submissionList` to get metadata for all submissions.
- For each submission ID, calls GraphQL `submissionDetails` to fetch code.
- Saves into <problem-slug>/<timestamp>_<id>_<lang>.ext
- Commits with GIT_AUTHOR_DATE/GIT_COMMITTER_DATE set to submission timestamp.
- Maintains .leetcode_sync_state.json so you can resume safely.

Environment:
  - LEETCODE_SESSION (required) -> your session cookie (set in GitHub Secrets)
  - REPO_PATH (optional) -> path to repo (default = workspace)
  - BRANCH (optional) -> branch name (default = main)
"""

import os, sys, time, json, requests, subprocess
from pathlib import Path
from datetime import datetime, timezone

LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")
REPO_PATH = Path(os.environ.get("REPO_PATH", os.getcwd()))
BRANCH = os.environ.get("BRANCH", "main")

if not LEETCODE_SESSION:
    print("ERROR: LEETCODE_SESSION not set. Exiting.")
    sys.exit(1)

if not (REPO_PATH.exists() and (REPO_PATH / ".git").exists()):
    print(f"ERROR: {REPO_PATH} is not a git repo.")
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
session.headers.update({"User-Agent":"leetcode-sync-script/1.0","Referer":"https://leetcode.com"})

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

# --- GraphQL helpers ---

def graphql_query(query, variables, max_retries=3):
    """Send GraphQL query with csrf + retry"""
    try:
        session.get("https://leetcode.com", timeout=15)
    except Exception:
        pass
    csrftoken = session.cookies.get("csrftoken") or ""
    headers = {
        "Referer":"https://leetcode.com",
        "X-Requested-With":"XMLHttpRequest",
        "User-Agent":session.headers.get("User-Agent","leetcode-sync"),
    }
    if csrftoken:
        headers["X-CSRFToken"] = csrftoken
    for attempt in range(1,max_retries+1):
        try:
            r = session.post("https://leetcode.com/graphql",
                             json={"query":query,"variables":variables},
                             headers=headers, timeout=30)
            if r.status_code == 200:
                return r.json()
            print("GraphQL status:", r.status_code, r.text[:200])
        except Exception as e:
            print("GraphQL error:", e)
        time.sleep(attempt)
    return None

def fetch_all_submissions(limit=50):
    """Fetch metadata for ALL submissions (no code)"""
    gql = """
    query submissionList($offset:Int!,$limit:Int!){
      submissionList(offset:$offset,limit:$limit){
        submissions{
          id
          title
          titleSlug
          statusDisplay
          lang
          timestamp
        }
        hasNext
      }
    }
    """
    subs = []
    offset = 0
    while True:
        body = graphql_query(gql, {"offset":offset,"limit":limit})
        if not body:
            break
        data = body.get("data",{}).get("submissionList",{})
        batch = data.get("submissions") or []
        subs.extend(batch)
        print(f"GraphQL: offset={offset}, got {len(batch)} submissions")
        if not data.get("hasNext") or len(batch)<limit:
            break
        offset += limit
        time.sleep(0.2)
    return subs

def fetch_submission_code(sub_id):
    """Fetch code for a single submission"""
    gql = """
    query submissionDetails($id:ID!){
      submissionDetails(submissionId:$id){
        id
        code
        lang
        timestamp
      }
    }
    """
    body = graphql_query(gql, {"id":str(sub_id)})
    if not body:
        return None
    return body.get("data",{}).get("submissionDetails",{})

# --- commit logic ---

def write_and_commit(sub):
    status = (sub.get("statusDisplay") or "").lower()
    if "accepted" not in status and not status.startswith("ac"):
        return False
    sub_id = sub.get("id")
    # fetch code
    details = fetch_submission_code(sub_id)
    if not details or not details.get("code"):
        print("No code for submission", sub_id)
        return False
    code = details["code"]
    lang = (details.get("lang") or sub.get("lang") or "").lower()
    ts = int(details.get("timestamp") or sub.get("timestamp") or 0)
    if not ts:
        return False
    title_slug = sub.get("titleSlug") or sub.get("title") or f"problem_{sub_id}"
    title = sub.get("title") or title_slug
    ext = EXT_MAP.get(lang,"txt")
    dt = datetime.fromtimestamp(ts, tz=timezone.utc)
    iso = dt.strftime("%Y-%m-%dT%H-%M-%SZ")
    filename = f"{iso}_{sub_id}_{lang}.{ext}"
    prob_dir = REPO_PATH / safe_filename(title_slug)
    prob_dir.mkdir(parents=True, exist_ok=True)
    file_path = prob_dir / filename
    if file_path.exists():
        return False
    with open(file_path,"w",encoding="utf-8") as f:
        f.write(f"// LeetCode: {title} ({title_slug})\n")
        f.write(f"// Submission ID: {sub_id}\n")
        f.write(f"// Language: {lang}\n")
        f.write(f"// Timestamp (UTC): {iso}\n\n")
        f.write(code)
    commit_msg = f"Add LeetCode: {title} ({title_slug}) — solved on {iso}"
    env = {"GIT_AUTHOR_DATE":iso,"GIT_COMMITTER_DATE":iso}
    run_git(["add", str(file_path)])
    run_git(["commit","-m",commit_msg], env=env)
    print("Committed", file_path)
    return True

# --- main ---

def main():
    state = load_state()
    processed = set(state.get("processed_ids", {}).keys())
    print("Fetching metadata...")
    subs = fetch_all_submissions(limit=50)
    print("Total metadata fetched:", len(subs))
    created=0
    for sub in reversed(subs):
        sid = str(sub.get("id"))
        if sid in processed:
            continue
        try:
            if write_and_commit(sub):
                created+=1
            state.setdefault("processed_ids",{})[sid]={
                "title": sub.get("title"),
                "ts": sub.get("timestamp"),
            }
            save_state(state)
        except Exception as e:
            print("Error:", e)
            save_state(state)
            raise
    print("Created commits:", created)
    try:
        run_git(["push","origin",BRANCH])
        print("Push successful.")
    except Exception as e:
        print("Push failed:", e)

if __name__=="__main__":
    main()
