// LeetCode: Squares of a Sorted Array (squares-of-a-sorted-array)
// Submission ID: 1656275607
// Language: java
// Timestamp (UTC): 2025-06-07T06:11:26Z

class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        
        return nums;
    }
}