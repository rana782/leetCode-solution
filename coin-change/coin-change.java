// LeetCode: Coin Change (coin-change)
// Submission ID: 1655079599
// Language: java
// Timestamp (UTC): 2025-06-05T19:49:01Z

class Solution {
    static Integer dp[];
    public static int solution(int coins[], int amount){
        if(amount <0)return Integer.MAX_VALUE;
        
        if(amount == 0)return 0;
        if(dp[amount]!=null)return dp[amount];
        
        int output = Integer.MAX_VALUE;
        
        for(int i = 0; i<coins.length; i++){
            int subAns = solution(coins,amount-coins[i]);
            if(subAns!=Integer.MAX_VALUE){
                output = Math.min(output,1+subAns);
            }
        }
        
        return dp[amount] = output;
    }
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1];
       
        int ans  = solution(coins,amount);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}