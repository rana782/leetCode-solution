// LeetCode: Number of Dice Rolls With Target Sum (number-of-dice-rolls-with-target-sum)
// Submission ID: 1667124819
// Language: java
// Timestamp (UTC): 2025-06-17T12:11:56Z

class Solution {
    
    static int mod = 1000000007;
    
    static int dp[][];
    
    public static int solution(int n,int target, int k){
        
        
        if(n == 0 && target == 0)return 1;
        
        if(n<0 || target<0)return 0;
        
        if(dp[n][target]!=-1)return dp[n][target];
        
        int output = 0;
        
        for(int i= 1; i<=k; i++){
              
           output  = (output+solution(n-1,target-i,k))%mod;
        }
        
        return dp[n][target] = output%mod;
    }
    public int numRollsToTarget(int n, int k, int target) {
       
        dp = new int[n+1][target+1];
        
       for(int d[] : dp){
           Arrays.fill(d,-1);
       }
        return solution(n,target,k);
     
    }
}