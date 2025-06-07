// LeetCode: Best Time to Buy and Sell Stock III (best-time-to-buy-and-sell-stock-iii)
// Submission ID: 1657044652
// Language: java
// Timestamp (UTC): 2025-06-07T21:43:23Z

class Solution {

    public static int solution(int idx, int buy, int cap, int prices[]){
        if(cap == 0)return 0;
        if(idx == prices.length)return 0;


        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[idx]+solution(idx+1,1,cap,prices),solution(idx+1,0,cap,prices));
        }
        else{
            profit = Math.max(prices[idx]+solution(idx+1,0,cap-1,prices),solution(idx+1,1,cap,prices));
        }

        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cap = 2;
        int dp[][][] = new int[n+1][2][cap+1];


        for(int idx = n-1; idx>=0; idx--){
            for(int buy = 0; buy<=1; buy++){
                for(int k = cap; k>0; k--){
                     int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[idx]+dp[idx+1][1][k],dp[idx+1][0][k]);
        }
        else{
            profit = Math.max(prices[idx]+dp[idx+1][0][k-1],dp[idx+1][1][k]);
        }

        dp[idx][buy][k]  = profit;
                }
            }
        }

       return dp[0][0][cap];
    }
}