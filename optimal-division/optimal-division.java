// LeetCode: Optimal Division (optimal-division)
// Submission ID: 1510544249
// Language: java
// Timestamp (UTC): 2025-01-16T15:00:41Z

class Solution {
    public String optimalDivision(int[] nums) {
        if(nums.length == 1)return String.valueOf(nums[0]);
        
        if(nums.length == 2) {
        	return String.valueOf(nums[0])+"/"+String.valueOf(nums[1]);
        }
        
        StringBuilder output = new StringBuilder();
        for(int i = 0; i<nums.length; i++) {
        	if(i == 0) {
        		output.append(String.valueOf(nums[0]));
        	}
        	else if(i == 1) {
        		output.append("/");
        		output.append("(");
        		output.append(nums[i]);
        	}
        	
        	else {
        		output.append("/");
        		output.append(nums[i]);
        	}
        	
        }
        
        output.append(")");
        
        return output.toString();
        
    }
}