// LeetCode: Maximum Product of Three Numbers (maximum-product-of-three-numbers)
// Submission ID: 1659303435
// Language: java
// Timestamp (UTC): 2025-06-10T04:28:35Z

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int p1 = 1;
       p1= nums[0]*nums[1]*nums[n-1];
        
        int p2 = nums[n-1]*nums[n-2]*nums[n-3];
        
        return Math.max(p1,p2);
    }
}