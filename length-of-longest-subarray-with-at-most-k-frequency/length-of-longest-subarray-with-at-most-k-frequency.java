// LeetCode: Length of Longest Subarray With at Most K Frequency (length-of-longest-subarray-with-at-most-k-frequency)
// Submission ID: 1599651258
// Language: java
// Timestamp (UTC): 2025-04-07T14:56:25Z

class Solution {
  
    public int maxSubarrayLength(int[] nums, int k) {
       int start = 0;
      

       int output = 0;

       HashMap<Integer,Integer>map = new HashMap<>();

       for(int end = 0; end<nums.length; end++){
        map.put(nums[end],map.getOrDefault(nums[end],0)+1);

        while (map.get(nums[end]) > k) {
            map.put(nums[start], map.get(nums[start]) - 1);
            if (map.get(nums[start]) == 0) {
                map.remove(nums[start]);
            }
            start++;
        }

        output = Math.max(output,end-start+1);

       } 

       return output;
    }
}