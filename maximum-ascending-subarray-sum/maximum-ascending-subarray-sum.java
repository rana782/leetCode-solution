// LeetCode: Maximum Ascending Subarray Sum (maximum-ascending-subarray-sum)
// Submission ID: 1530978480
// Language: java
// Timestamp (UTC): 2025-02-04T12:06:12Z

class Solution {
    public int maxAscendingSum(int[] nums) {
        if(nums.length == 1) return nums[0];


        int totalMaxSum = 0;


        for(int i = 0; i<nums.length-1; i++){

            int currSum = nums[i];
             totalMaxSum = Math.max(currSum,totalMaxSum);
            for(int j = i+1; j<nums.length; j++){
              if(nums[j]>nums[j-1]){
                currSum+=nums[j];
                totalMaxSum = Math.max(currSum,totalMaxSum);
              }
              else{
                break;
              }

             
            }
        }

        return totalMaxSum;
    }
}