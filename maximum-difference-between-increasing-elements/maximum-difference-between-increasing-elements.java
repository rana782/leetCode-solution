// LeetCode: Maximum Difference Between Increasing Elements (maximum-difference-between-increasing-elements)
// Submission ID: 1665946017
// Language: java
// Timestamp (UTC): 2025-06-16T11:17:37Z

class Solution {
    public int maximumDifference(int[] nums) {
        int currMin = nums[0];
        int output = 0;

        for(int i = 1; i<nums.length; i++){
            if(nums[i]>currMin){
                int diff = nums[i]-currMin;
                output = Math.max(output,diff);
            }
            else{
                currMin = Math.min(nums[i],currMin);
            }
        }

        return output == 0 ? -1 : output;
    }
}