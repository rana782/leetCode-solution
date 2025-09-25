#!/usr/bin/env python3
"""
leetcode_sync.py
- Fetch ALL LeetCode submissions via GraphQL (uses larger page size)
- Keep latest accepted per problem
- Save each in its own folder (slug/slug.ext)
- One commit per problem, backdated to original submission time
- Skip commit if file already exists with identical content (idempotent)
"""

import os, sys, time, requests, subprocess
from pathlib import Path
from datetime import datetime, timezone
import hashlib

# -------------------- Config --------------------

LEETCODE_SESSION = os.environ.get("LEETCODE_SESSION")  # required
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
    "php":"php","typescript":"ts"
}

session = requests.Session()
session.cookies.set("LEETCODE_SESSION", LEETCODE_SESSION, domain=".leetcode.com")
session.headers.update({"User-Agent":"leetcode-sync-script/1.0","Referer":"https://leetcode.com"})

# -------------------- Helpers --------------------

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
    """Normalize timestamp to int seconds"""
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
            print("GraphQL status:", r.status_code, r.text[:300])
        except Exception as e:
            print("GraphQL error:", e)
        time.sleep(attempt)
    return None

def fetch_all_submissions(limit=1000):
    """
    Fetch metadata for ALL submissions.
    Uses a large default limit to request many items per page.
    (If server limits it, pagination still continues.)
    """
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
        body = graphql_query(gql, {"offset": offset, "limit": limit})
        if not body:
            break
        data = body.get("data", {}).get("submissionList", {})
        batch = data.get("submissions") or []
        for item in batch:
            item["timestamp"] = to_int_ts(item.get("timestamp"))
            item["lang_name"] = item.get("lang") or ""
        subs.extend(batch)
        print(f"GraphQL: offset={offset}, got {len(batch)} submissions")
        if not data.get("hasNext") or len(batch) < limit:
            break
        offset += limit
        time.sleep(0.2)
    return subs

def fetch_submission_code(sub_id):
    """Fetch full code for a single submission (lang is LanguageNode)."""
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
    body = graphql_query(gql, {"submissionId": sid})
    if not body:
        return None
    details = body.get("data", {}).get("submissionDetails", {})
    if details:
        if isinstance(details.get("lang"), dict):
            details["lang"] = details["lang"].get("name") or ""
        details["timestamp"] = to_int_ts(details.get("timestamp"))
    return details

# -------------------- Main --------------------

def main():
    print("Fetching metadata...")
    subs = fetch_all_submissions(limit=1000)  # large page size
    print("Total submissions fetched:", len(subs))

    # keep only latest accepted per problem
    latest = {}
    for sub in subs:
        status = (sub.get("statusDisplay") or "").lower()
        if "accepted" not in status and not status.startswith("ac"):
            continue
        slug = sub.get("titleSlug") or sub.get("title")
        ts = to_int_ts(sub.get("timestamp"))
        if not slug or ts == 0:
            continue
        prev = latest.get(slug)
        if (prev is None) or (ts > to_int_ts(prev.get("timestamp"))):
            sub_copy = dict(sub)
            sub_copy["timestamp"] = ts
            latest[slug] = sub_copy

    print("Problems solved (unique):", len(latest))

    created = 0
    for slug, sub in latest.items():
        details = fetch_submission_code(sub.get("id"))
        if not details or not details.get("code"):
            print("No code for", slug)
            continue

        code = details["code"]
        lang = (details.get("lang") or sub.get("lang_name") or "").lower()
        ext = EXT_MAP.get(lang, "txt")
        ts = to_int_ts(details.get("timestamp") or sub.get("timestamp"))
        if ts == 0:
            print("Skipping", slug, "because timestamp missing")
            continue

        dt = datetime.fromtimestamp(ts, tz=timezone.utc)
        iso = dt.strftime("%Y-%m-%dT%H:%M:%SZ")

        folder = REPO_PATH / safe_filename(slug)
        folder.mkdir(parents=True, exist_ok=True)
        file_path = folder / f"{safe_filename(slug)}.{ext}"

        new_content = (
            f"// LeetCode: {sub.get('title')} ({slug})\n"
            f"// Submission ID: {sub.get('id')}\n"
            f"// Language: {lang}\n"
            f"// Timestamp (UTC): {iso}\n\n"
            f"{code}"
        )

        # if identical, skip commit (idempotent)
        if file_exists_and_same(file_path, new_content):
            # no change
            continue

        # write and commit (backdated)
        with open(file_path, "w", encoding="utf-8") as f:
            f.write(new_content)

        run_git(["add", str(file_path)])
        commit_msg = f"Latest LeetCode: {sub.get('title')} ({slug}) — solved on {iso}"
        env = {"GIT_AUTHOR_DATE": iso, "GIT_COMMITTER_DATE": iso}
        run_git(["commit", "-m", commit_msg], env=env)
        print("Committed", slug, "at", iso)
        created += 1

    print("Created commits:", created)
    if created > 0:
        run_git(["push", "origin", BRANCH])
        print("Push successful.")
    else:
        print("No new commits — all up to date.")

if __name__ == "__main__":
    main()
