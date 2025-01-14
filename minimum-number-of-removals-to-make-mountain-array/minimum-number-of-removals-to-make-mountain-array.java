// LeetCode: Minimum Number of Removals to Make Mountain Array (minimum-number-of-removals-to-make-mountain-array)
// Submission ID: 1508398809
// Language: java
// Timestamp (UTC): 2025-01-14T14:17:41Z

class Solution {
    public int minimumMountainRemovals(int[] nums) {
	        int n = nums.length;
	        
	        int lis[] = new int[n];
	         int lds[] = new int[n];
	         
	         
	         // calculating length of lis at each index
	         
	         for(int i = 0; i<n; i++) {
	        	  int max = 0;
	        	  
	        	  for(int j = 0; j<i; j++) {
	        		  if(nums[j]<nums[i]) {
	        			  max = Math.max(max, lis[j]);
	        		  }
	        	  }
	        	  
	        	  lis[i] = max+1;
	         }
	         
	         //calculating the length of lds for  each index
	         
	         for(int i = n-1; i>=0; i--) {
	        	 int max = 0;
	        	 for(int j = n-1; j>i; j--) {
	        		 if(nums[j]<nums[i]) {
	        			 max = Math.max(max, lds[j]);
	        		 }
	        	 }
	        	 
	        	 lds[i] = max+1;
	         }
	         
	         int peakMountainLength = Integer.MIN_VALUE;
	         
	         for(int i = 0; i<n; i++) {
	        	if(lis[i]>1 && lds[i]>1){
                     int currLength = lis[i]+lds[i]-1;
	        	 peakMountainLength = Math.max(peakMountainLength, currLength);
                }
	         }
	         
	         return n-peakMountainLength;
	    }
}