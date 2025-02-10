// LeetCode: Range Sum of Sorted Subarray Sums (range-sum-of-sorted-subarray-sums)
// Submission ID: 1538279498
// Language: java
// Timestamp (UTC): 2025-02-10T16:16:49Z

class Solution {
  public int rangeSum(int[] nums, int n, int left, int right) {
	        ArrayList<Integer> mergedNums = new ArrayList<>();
           for(int i = 0; i<nums.length-1; i++){
            mergedNums.add(nums[i]);
            int prefixSum = nums[i];

            for(int j = i+1; j<nums.length; j++){
                 prefixSum+=nums[j];

                 
                 mergedNums.add(prefixSum);
            }
           }
           mergedNums.add(nums[nums.length-1]);
	       
	       Collections.sort(mergedNums);
         
	       int output = 0;
	       int mod = 1000000007;
	       
	       for(int i = left; i<=right; i++) {
	    	   output+=mergedNums.get(i-1);
	    	   output = output%mod;
	       }
	       
	       return output;
	    }
}
