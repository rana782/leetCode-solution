// LeetCode: Largest Positive Integer That Exists With Its Negative (largest-positive-integer-that-exists-with-its-negative)
// Submission ID: 1509390600
// Language: java
// Timestamp (UTC): 2025-01-15T13:24:31Z

class Solution {
    public int findMaxK(int[] nums) {
		 
		 if(nums.length == 1) return -1;
	       HashSet<Integer> set = new HashSet<>(); 
	       int output = Integer.MIN_VALUE;
	       
	       for(int i = 0; i<nums.length; i++) {
	    	   if(nums[i]<0) set.add(nums[i]);
	       }
	       
	       for(int i = 0; i<nums.length; i++) {
	    	   if(nums[i]>0) {
	    		   int negativeNum = -1*nums[i];
	    		   if(set.contains(negativeNum)) {
	    			   output = Math.max(output, nums[i]);
	    		   }
	    		   
	    	   }
	       }
	       
	       return output == Integer.MIN_VALUE ? -1 : output;
	    }
}