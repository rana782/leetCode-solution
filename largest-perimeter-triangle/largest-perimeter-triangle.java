// LeetCode: Largest Perimeter Triangle (largest-perimeter-triangle)
// Submission ID: 1603622895
// Language: java
// Timestamp (UTC): 2025-04-11T12:20:44Z

class Solution {
    public int largestPerimeter(int[] nums) {
  Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if(nums[i-2] + nums[i-1] > nums[i]){
                return nums[i-2] + nums[i-1] + nums[i];
            }
        }
        return 0;
}
}