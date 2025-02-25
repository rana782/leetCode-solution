// LeetCode: Number of Sub-arrays With Odd Sum (number-of-sub-arrays-with-odd-sum)
// Submission ID: 1554686383
// Language: java
// Timestamp (UTC): 2025-02-25T07:17:30Z

class Solution {
    public int numOfSubarrays(int[] arr) {
	       int oddSum = 0;
	       int evenSum = 1;
	       
	       int prefixSum = 0;
	       int output = 0;
	       
	       int mod = 1000000007;
	       
	       for(int i = 0; i<arr.length; i++) {
	    	   prefixSum+=arr[i];
	    	   
	    	   if(prefixSum%2!=0) {
	    		  output = (output+evenSum)%mod;
	    		   oddSum++;
	    	   }
	    	   
	    	   else {
	    		   output = (output+oddSum)%mod;
	    		   evenSum++;
	    	   }
	       }
	       
	       
	       return output;
	    }
}