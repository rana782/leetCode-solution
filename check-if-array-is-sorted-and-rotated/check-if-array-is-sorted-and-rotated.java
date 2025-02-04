// LeetCode: Check if Array Is Sorted and Rotated (check-if-array-is-sorted-and-rotated)
// Submission ID: 1530948297
// Language: java
// Timestamp (UTC): 2025-02-04T11:26:17Z

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        for(int i  = 0; i<nums.length; i++){
              if(nums[i]>nums[(i+1)%nums.length])count++;

              if(count>1) return false;
        }

        return true;
    }
}