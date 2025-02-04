// LeetCode: Longest Strictly Increasing or Strictly Decreasing Subarray (longest-strictly-increasing-or-strictly-decreasing-subarray)
// Submission ID: 1530966268
// Language: java
// Timestamp (UTC): 2025-02-04T11:50:34Z

class Solution {
 	
	public static int getInc(int nums[]) {
		int output = 0;
		int currLength = 1;
		
		
		for(int i = 1; i<nums.length; i++) {
			
			if(nums[i]>nums[i-1]){
                   currLength++;
              	output = Math.max(currLength, output);
            }
			
			else {
			
				currLength = 1;
			}
		}
		
		output = Math.max(currLength,output);
		return output;
	}
	
	
	
	public static int getDec(int nums[]) {
		int output = 0;
		int currLength = 1;
		
		
		for(int i = 1; i<nums.length; i++) {
			
			if(nums[i]<nums[i-1]){
                   currLength++;
              	output = Math.max(currLength, output);
            }
			
			else {
			
				currLength = 1;
			}
		}
		
		output = Math.max(currLength,output);
		return output;
	}
	
	 public int longestMonotonicSubarray(int[] nums) {
	        if(nums.length == 1) return 1;
	        
	        int incLength = getInc(nums);
	        int decLength = getDec(nums);
            System.out.println(incLength);

            System.out.println(decLength);
            
	        
	        
	        return incLength>decLength ? incLength : decLength;
	        
	    }
}