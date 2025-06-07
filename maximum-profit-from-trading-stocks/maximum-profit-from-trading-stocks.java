// LeetCode: Maximum Profit From Trading Stocks (maximum-profit-from-trading-stocks)
// Submission ID: 1657057024
// Language: java
// Timestamp (UTC): 2025-06-07T22:11:57Z

class Solution {
    static int dp[][];
    public static int solution(int idx, int currWt, int[] p, int[] f) {
        if (idx < 0 || currWt < 0) return 0;

        if(dp[idx][currWt]!=-1)return dp[idx][currWt];

        int notTaken = solution(idx - 1, currWt, p, f);
        int taken = Integer.MIN_VALUE;

        if (p[idx] <= currWt) {
            taken = (f[idx] - p[idx]) + solution(idx - 1, currWt - p[idx], p, f);
        }

        return dp[idx][currWt] = Math.max(taken, notTaken);
    }

    public int maximumProfit(int[] present, int[] future, int budget) {
       
        int n = present.length;
         dp = new int[n+1][budget+1];

         for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
         }
        return solution(n - 1, budget, present, future);
    }
}
