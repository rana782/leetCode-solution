// LeetCode: Partition Equal Subset Sum (partition-equal-subset-sum)
// Submission ID: 1599331927
// Language: java
// Timestamp (UTC): 2025-04-07T08:14:40Z

class Solution {

    	public static boolean solution(int nums[], int sum) {
	    
		
		boolean dp[][] = new boolean[nums.length+1][sum+1];
		
		for(int j = 1; j<dp[0].length; j++) {
			dp[0][j] = false;
		}
		
		for(int i = 0; i<dp.length; i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i<dp.length; i++) {
			for(int j = 1; j<dp[0].length; j++) {
				
				dp[i][j] = dp[i-1][j];
				
				if(j>=nums[i-1]) {
					dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
				}
			}
		}
		
		return dp[nums.length][sum];
	}

    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }

        sum = sum/2;

        boolean output = solution(nums,sum);

        return output;
      
        
    }
}