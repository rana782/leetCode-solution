// LeetCode: Shortest Unsorted Continuous Subarray (shortest-unsorted-continuous-subarray)
// Submission ID: 1514578361
// Language: java
// Timestamp (UTC): 2025-01-20T13:06:44Z

class Solution {
    	 public int findUnsortedSubarray(int[] nums) {
	        if(nums.length == 1) return 0;
	        
	        int n = nums.length;
	        
	        int cpyArr[] = new int[n];
	        
	        for(int i = 0; i<n; i++) {
	        	cpyArr[i] = nums[i];
	        }
	        
	        Arrays.sort(cpyArr);
	        
	        boolean firstIdx = true;
	        
	        int idx1 = 0;
	        int idx2 = 0;
	        
	        for(int i = 0; i<n; i++) {
	        	
	        	if(cpyArr[i]!=nums[i]) {
	        		
	        		if(firstIdx) {
	        			idx1 = i;
	        			firstIdx = false;
	        		}
	        		
	        		else {
	        			idx2 = i;
	        		}
	        	}
	        }
	        
	        return idx1 == 0 && idx2 == 0 ? 0 : (idx2-idx1)+1;
	    }
}