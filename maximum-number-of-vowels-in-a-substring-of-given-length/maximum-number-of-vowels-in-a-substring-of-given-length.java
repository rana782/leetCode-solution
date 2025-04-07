// LeetCode: Maximum Number of Vowels in a Substring of Given Length (maximum-number-of-vowels-in-a-substring-of-given-length)
// Submission ID: 1599588830
// Language: java
// Timestamp (UTC): 2025-04-07T13:46:23Z

class Solution {
    public int maxVowels(String s, int k) {
    int max = 0, count = 0;

    for (int i = 0; i < s.length(); i++) {
        if (isVowel(s.charAt(i))) count++;
        if (i >= k && isVowel(s.charAt(i - k))) count--;
        max = Math.max(max, count);
    }

    return max;
}

private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}
}