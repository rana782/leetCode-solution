// LeetCode: Minimum Value to Get Positive Step by Step Sum (minimum-value-to-get-positive-step-by-step-sum)
// Submission ID: 1335947276
// Language: java
// Timestamp (UTC): 2024-07-28T06:51:50Z

class Solution {
    public int minStartValue(int[] nums) {
        int ans = 0;
        int curr = 0;

        for(int i =0; i<nums.length; i++){
            curr+=nums[i];
            ans = Math.min(ans,curr);
        }
        return Math.abs(ans)+1;
    }
}