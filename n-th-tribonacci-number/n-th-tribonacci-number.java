// LeetCode: N-th Tribonacci Number (n-th-tribonacci-number)
// Submission ID: 1659340927
// Language: java
// Timestamp (UTC): 2025-06-10T05:08:35Z

class Solution {
    public int tribonacci(int n) {
        if(n == 0 || n == 1)return n;
        if(n == 2) return 1;
        
        int dp[] = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        
        return dp[n];
    }
}