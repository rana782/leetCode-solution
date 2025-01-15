// LeetCode: Count Number of Distinct Integers After Reverse Operations (count-number-of-distinct-integers-after-reverse-operations)
// Submission ID: 1509411669
// Language: java
// Timestamp (UTC): 2025-01-15T13:49:36Z

class Solution {
     public int countDistinctIntegers(int[] nums) {
	      HashSet<Integer> set = new HashSet<>();
	      
	      for(int i = 0; i<nums.length; i++) {
	    	  set.add(nums[i]);
	    	  
	    	  if(nums[i]>9) {
	    		  int reversedDigit = getReversedDigit(nums[i]);
	    		  set.add(reversedDigit);
	    	  }
	      }
	      
	      return set.size();
	    }

	private int getReversedDigit(int i) {
		int output = 0;
		
		while(i!=0) {
			int rem = i%10;
			output = (output*10)+rem;
			i = i/10;
		}
		
		return output;
	}
}