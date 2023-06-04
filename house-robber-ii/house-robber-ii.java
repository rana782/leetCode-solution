// LeetCode: House Robber II (house-robber-ii)
// Submission ID: 1559070830
// Language: java
// Timestamp (UTC): 2025-03-01T11:13:34Z

class Solution {

    	public static int solution(int nums[], int idx,int avoidIdx, int dp[]) {
	if(idx>=nums.length || idx == avoidIdx) return 0;
	
	if(dp[idx]!=-1) return dp[idx];
	
	int inc = nums[idx]+solution(nums, idx+2, avoidIdx, dp);
	int exc = solution(nums, idx+1, avoidIdx,dp);
	return dp[idx] = Math.max(inc, exc);
	}
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        int inc = solution(nums,0,nums.length-1,dp);

         dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int exc = solution(nums,1,-1,dp);

        return Math.max(inc,exc);


    }
}