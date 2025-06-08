// LeetCode: Best Time to Buy and Sell Stock (best-time-to-buy-and-sell-stock)
// Submission ID: 1657819175
// Language: java
// Timestamp (UTC): 2025-06-08T16:17:55Z

class Solution {
    public int maxProfit(int[] prices) {
        
        int output = 0;
        int currMin = prices[0];
        for(int i = 1; i<prices.length; i++){
            int currProfit = prices[i]-currMin;
            
            output = Math.max(output,currProfit);
            currMin = Math.min(currMin,prices[i]);
        }
        
        
        return output<=0 ? 0 : output;
    }
}