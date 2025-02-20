// LeetCode: Repeated String Match (repeated-string-match)
// Submission ID: 1550026523
// Language: java
// Timestamp (UTC): 2025-02-20T19:42:04Z

class Solution {
  
	public static int repeatedStringMatch(String a, String b) {
    StringBuilder str = new StringBuilder(a);
    int count = 1;

    // Append `a` until `str` reaches at least `b.length()`
    while (str.length() < b.length()) {
        str.append(a);
        count++;
    }

    // Check if `b` is present
    if (str.toString().contains(b)) return count;

    // Append one more time to cover the edge case
    str.append(a);
    count++;

    return str.toString().contains(b) ? count : -1;
}

}