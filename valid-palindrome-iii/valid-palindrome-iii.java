// LeetCode: Valid Palindrome III (valid-palindrome-iii)
// Submission ID: 1640225900
// Language: java
// Timestamp (UTC): 2025-05-21T11:07:39Z

class Solution {

       public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single characters are palindromes of length 1
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the table bottom-up
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (i+1 <= j-1 ? dp[i+1][j-1] : 0);
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];  // result for the full string
    }
    public boolean isValidPalindrome(String s, int k) {
        int subSeqLength = longestPalindromeSubseq(s);

        if(s.length()-subSeqLength<=k)return true;

        return false;
    }
}