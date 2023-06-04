// LeetCode: Maximum Product Difference Between Two Pairs (maximum-product-difference-between-two-pairs)
// Submission ID: 963602916
// Language: java
// Timestamp (UTC): 2023-06-04T10:10:38Z

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int max = (nums[nums.length-1]*nums[nums.length-2])-(nums[0]*nums[1]);
        return max;
    }
}