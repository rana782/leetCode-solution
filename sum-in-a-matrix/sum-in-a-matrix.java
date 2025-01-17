// LeetCode: Sum in a Matrix (sum-in-a-matrix)
// Submission ID: 1511233643
// Language: java
// Timestamp (UTC): 2025-01-17T06:45:42Z

class Solution {
      public int matrixSum(int[][] nums) {
        int output = 0;
        
        for(int i = 0; i<nums.length; i++) {
        	Arrays.sort(nums[i]);
        }
        
        for(int j = nums[0].length-1; j>=0; j--) {
        	
        	int maxElement = Integer.MIN_VALUE;
        	for(int i = 0; i<nums.length; i++) {
        		maxElement = Math.max(maxElement, nums[i][j]);
        	}
        	
        	output+=maxElement;
        }
        
        return output;
    }
}