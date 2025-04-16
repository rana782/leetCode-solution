// LeetCode: Number of Subarrays That Match a Pattern I (number-of-subarrays-that-match-a-pattern-i)
// Submission ID: 1608882015
// Language: java
// Timestamp (UTC): 2025-04-16T19:28:27Z

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        int m = pattern.length;
        
        for(int i = 0; i<nums.length-m; i++) {
        	
        	int condition = 0;
        	
        	for(int k = 0; k<pattern.length; k++) {
        		
        		if(pattern[k] == 1) {
        			if(nums[i+k+1]>nums[i+k])condition++;
        			else {
        				break;
        			}
        		}
        		
        		else if(pattern[k] == 0) {
        			if(nums[i+k+1]==nums[i+k])condition++;
        			else {
        				break;
        			}
        		}
        		
        		else if(pattern[k] == -1) {
        			if(nums[i+k+1]<nums[i+k])condition++;
        			else {
        				break;
        			}
        		}
        	}
        	
        	if(condition == m) count++;
        }
        
        return count;
    }
}