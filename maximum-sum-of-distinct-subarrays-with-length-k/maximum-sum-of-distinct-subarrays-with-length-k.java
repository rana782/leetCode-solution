// LeetCode: Maximum Sum of Distinct Subarrays With Length K (maximum-sum-of-distinct-subarrays-with-length-k)
// Submission ID: 1600525247
// Language: java
// Timestamp (UTC): 2025-04-08T10:46:02Z

class Solution {
  		  public long maximumSubarraySum(int[] nums, int k) {
	       long res = 0;
	       int start = 0;
	       
	       HashMap<Integer,Integer>map = new HashMap<>();
	       long sum = 0;
	       
	       for(int i = 0; i<k; i++) {
	    	   map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	    	   sum+=nums[i];
	       }
	       
	       if(map.size() == k)res = Math.max(res, sum);
	       
	       for(int i = k; i<nums.length; i++) {
	    	   sum+=nums[i];
	    	   sum-=nums[start];
	    	   
	    	   map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	    	   
	    	   map.put(nums[start],map.get(nums[start])-1);
	    	   if(map.get(nums[start]) == 0)map.remove(nums[start]);
	    	   start++;
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   if(map.size() == k)res = Math.max(res, sum);
	    		 
	       }
	       
	       
	       return res;
	       
	       
	       
	      
	    }

}