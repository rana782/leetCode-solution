// LeetCode: Best Time to Buy and Sell Stock IV (best-time-to-buy-and-sell-stock-iv)
// Submission ID: 1657045829
// Language: java
// Timestamp (UTC): 2025-06-07T21:45:53Z

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int cap = k;
        int dp[][][] = new int[n+1][2][cap+1];


        for(int idx = n-1; idx>=0; idx--){
            for(int buy = 0; buy<=1; buy++){
                for(int j = cap; j>0; j--){
                     int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[idx]+dp[idx+1][1][j],dp[idx+1][0][j]);
        }
        else{
            profit = Math.max(prices[idx]+dp[idx+1][0][j-1],dp[idx+1][1][j]);
        }

        dp[idx][buy][j]  = profit;
                }
            }
        }

       return dp[0][0][cap];
    }
}