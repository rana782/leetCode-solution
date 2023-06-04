// LeetCode: Apply Operations to an Array (apply-operations-to-an-array)
// Submission ID: 1558902598
// Language: java
// Timestamp (UTC): 2025-03-01T07:23:42Z

class Solution {
    public int[] applyOperations(int[] nums) {
        int output[] = new int[nums.length];

        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }

        int idx = 0;
 for(int i = 0; i<nums.length; i++){
    if(nums[i]!=0){
        output[idx++] = nums[i];
    }
 }

 return output;
    }
}