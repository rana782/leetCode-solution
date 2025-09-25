#!/usr/bin/env python3
"""
leetcode_sync.py (one big commit, overwrite-safe)
- Fetches latest accepted submission per problem from LeetCode
- Stores each in its own folder (e.g. two-sum/two-sum.java)
- Overwrites existing files on re-runs
- Creates ONE commit if something actually changed
"""

import os, sys, time, requests, subprocess, hashlib
from pathlib import Path

LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")
REPO_PATH = Path(os.environ.get("REPO_PATH", os.getcwd()))
BRANCH = os.environ.get("BRANCH", "main")

if not LEETCODE_SESSION:
    print("ERROR: LEETCODE_SESSION not set. Exiting.")
    sys.exit(1)

if not (REPO_PATH.exists() and (REPO_PATH / ".git").exists()):
    print(f"ERROR: {REPO_PATH} is not a git repo.")
    sys.exit(1)

EXT_MAP = {
    "cpp":"cpp","c++":"cpp","java":"java","python":"py","python3":"py",
    "c":"c","c#":"cs","csharp":"cs","javascript":"js","ruby":"rb",
    "swift":"swift","go":"go","rust":"rs","kotlin":"kt","scala":"scala",
    "php":"php",
}

session = requests.Session()
session.cookies.set("LEETCODE_SESSION", LEETCODE_SESSION, domain=".leetcode.com")
session.headers.update({"User-Agent":"leetcode-sync-script/1.0","Referer":"https://leetcode.com"})

# -------------------- helpers --------------------

def run_git(args):
    res = subprocess.run(["git"] + args, cwd=str(REPO_PATH),
                         text=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    if res.returncode != 0:
        print("Git error:", res.returncode)
        print(res.stdout, res.stderr)
        raise SystemExit(res.returncode)
    return res.stdout.strip()

def safe_filename(s):
    return "".join(c if c.isalnum() or c in "-_." else "_" for c in (s or ""))

def file_checksum(path):
    """Return SHA1 of file contents, or None if not exist"""
    if not path.exists():
        return None
    h = hashlib.sha1()
    with open(path, "rb") as f:
        while chunk := f.read(8192):
            h.update(chunk)
    return h.hexdigest()

# -------------------- GraphQL --------------------

def graphql_query(query, variables, max_retries=3):
    """Send GraphQL query with csrf + retry"""
    try:
        session.get("https://leetcode.com", timeout=15)
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
    for attempt in range(1, max_retries + 1):
        try:
            r = session.post("https://leetcode.com/graphql",
                             json={"query": query, "variables": variables},
                             headers=headers, timeout=30)
            if r.status_code == 200:
                return r.json()
            print("GraphQL status:", r.status_code, r.text[:200])
        except Exception as e:
            print("GraphQL error:", e)
        time.sleep(attempt)
    return None

def fetch_all_submissions(limit=50):
    """Fetch metadata for ALL submissions."""
    gql = """
    query submissionList($offset:Int!,$limit:Int!){
      submissionList(offset:$offset,limit:$limit){
        submissions{
          id
          title
          titleSlug
          statusDisplay
          lang { name }
          timestamp
        }
        hasNext
      }
    }
    """
    subs = []
    offset = 0
    while True:
        body = graphql_query(gql, {"offset": offset, "limit": limit})
        if not body:
            break
        data = body.get("data", {}).get("submissionList", {})
        batch = data.get("submissions") or []
        for item in batch:
            lang_obj = item.get("lang")
            if isinstance(lang_obj, dict):
                item["lang_name"] = lang_obj.get("name") or ""
            else:
                item["lang_name"] = str(lang_obj or "")
        subs.extend(batch)
        print(f"GraphQL: offset={offset}, got {len(batch)} submissions")
        if not data.get("hasNext") or len(batch) < limit:
            break
        offset += limit
        time.sleep(0.2)
    return subs

def fetch_submission_code(sub_id):
    """Fetch full code for a single submission."""
    gql = """
    query submissionDetails($submissionId:Int!){
      submissionDetails(submissionId:$submissionId){
        id
        code
        lang
        timestamp
      }
    }
    """
    try:
        sid = int(sub_id)
    except Exception:
        print("Invalid submission id:", sub_id)
        return None
    body = graphql_query(gql, {"submissionId": sid})
    if not body:
        return None
    return body.get("data", {}).get("submissionDetails", {})

# -------------------- main --------------------

def main():
    print("Fetching metadata...")
    subs = fetch_all_submissions(limit=50)
    print("Total submissions fetched:", len(subs))

    # keep only latest accepted per problem
    latest = {}
    for sub in subs:
        status = (sub.get("statusDisplay") or "").lower()
        if "accepted" not in status and not status.startswith("ac"):
            continue
        slug = sub.get("titleSlug") or sub.get("title")
        ts = int(sub.get("timestamp") or 0)
        if not slug or not ts:
            continue
        if slug not in latest or ts > latest[slug].get("timestamp", 0):
            latest[slug] = sub

    print("Problems solved:", len(latest))

    changed = 0
    for slug, sub in latest.items():
        details = fetch_submission_code(sub.get("id"))
        if not details or not details.get("code"):
            print("No code for", slug)
            continue
        code = details["code"]
        lang = (details.get("lang") or sub.get("lang_name") or "").lower()
        ext = EXT_MAP.get(lang, "txt")

        folder = REPO_PATH / safe_filename(slug)
        folder.mkdir(parents=True, exist_ok=True)
        file_path = folder / f"{safe_filename(slug)}.{ext}"

        new_content = (
            f"// LeetCode: {sub.get('title')} ({slug})\n"
            f"// Submission ID: {sub.get('id')}\n"
            f"// Language: {lang}\n\n"
            f"{code}"
        )

        old_hash = file_checksum(file_path)
        new_hash = hashlib.sha1(new_content.encode("utf-8")).hexdigest()

        if old_hash != new_hash:
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(new_content)
            run_git(["add", str(file_path)])
            changed += 1

    if changed > 0:
        run_git(["commit", "-m", f"Sync latest accepted LeetCode solutions ({changed} updated)"])
        run_git(["push", "origin", BRANCH])
        print("Committed & pushed", changed, "solutions in one commit.")
    else:
        print("No changes to commit — repo already up to date.")

if __name__ == "__main__":
    main()
