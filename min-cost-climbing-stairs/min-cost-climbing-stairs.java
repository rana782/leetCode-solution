// LeetCode: Min Cost Climbing Stairs (min-cost-climbing-stairs)
// Submission ID: 1666546861
// Language: java
// Timestamp (UTC): 2025-06-16T22:58:42Z

class Solution {
    static int dp[];
    public static int solution(int idx, int cost[]){
        
        if(idx>=cost.length)return 0;
       if(dp[idx]!=-1)return dp[idx];
        
        int one_step = cost[idx]+solution(idx+1,cost);
        int two_step = cost[idx]+solution(idx+2,cost);
        
        return dp[idx] = Math.min(one_step,two_step);
    }
    public int minCostClimbingStairs(int[] cost) {
        
         
        dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
         int s1 = solution(0,cost);
        
        Arrays.fill(dp,-1);
         int s2 = solution(1,cost);
        
        return Math.min(s1,s2);
    }
}