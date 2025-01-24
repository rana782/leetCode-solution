// LeetCode: Maximum Length of Repeated Subarray (maximum-length-of-repeated-subarray)
// Submission ID: 1518930353
// Language: java
// Timestamp (UTC): 2025-01-24T10:29:45Z

class Solution {
    	
	 public int findLength(int[] nums1, int[] nums2) {
        int output = 0;
	        int matrix[][] = new int[nums1.length+1][nums2.length+1];
	        
	        for(int i = matrix.length-2; i>=0; i--) {
	        	for(int j = matrix[0].length-2; j>=0; j--) {
	        		
	        		

        			if(nums1[i] == nums2[j]) {
        				matrix[i][j] = 1+matrix[i+1][j+1];
                        output = Math.max(output,matrix[i][j]);
        			}
        			
        			else {
        				matrix[i][j] = 0;
        			}
	        	}
	        }
	        
	        
	        return output;
	    }
}