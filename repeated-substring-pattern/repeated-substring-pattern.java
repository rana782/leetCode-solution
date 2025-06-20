// LeetCode: Repeated Substring Pattern (repeated-substring-pattern)
// Submission ID: 1669996456
// Language: java
// Timestamp (UTC): 2025-06-20T02:03:15Z

class Solution {
 public boolean repeatedSubstringPattern(String s) {
    String doubled = s + s;
    return doubled.substring(1, doubled.length() - 1).contains(s);
}

}