// LeetCode: Maximum Absolute Sum of Any Subarray (maximum-absolute-sum-of-any-subarray)
// Submission ID: 1555802708
// Language: java
// Timestamp (UTC): 2025-02-26T07:11:13Z

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currBest = nums[0];
        int plusMax = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(currBest+nums[i]>nums[i]){
                currBest+=nums[i];
            }
            else{
                currBest = nums[i];
            }

            plusMax = Math.max(plusMax,currBest);
        }

        currBest = nums[0];
        int negMin = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(currBest+nums[i]<nums[i]){
                currBest+=nums[i];
            }
            else{
                currBest = nums[i];
            }

            negMin = Math.min(negMin,currBest);
        }

        return Math.max(plusMax,Math.abs(negMin));
        
    }
}