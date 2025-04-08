// LeetCode: Continuous Subarrays (continuous-subarrays)
// Submission ID: 1600562797
// Language: java
// Timestamp (UTC): 2025-04-08T11:42:48Z

class Solution {
     public long continuousSubarrays(int[] nums) {
	       TreeMap<Integer,Integer>map = new TreeMap<>(); 
	       
	       long count = 0;
	       
	       int start = 0;
	       
	       for(int end = 0; end<nums.length; end++) {
	    	   map.put(nums[end],map.getOrDefault(nums[end],0)+1);
	    	   
	    	   while(start<=end && map.lastKey()-map.firstKey()>2) {
	    		   map.put(nums[start],map.get(nums[start])-1);
	    		   
	    		   if(map.get(nums[start]) == 0)map.remove(nums[start]);
	    		   start++;
	    	   }
	    	   
	    	   count+=end-start+1;
	       }
	       
	       return count;
	    }
}