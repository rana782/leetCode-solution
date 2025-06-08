// LeetCode: Maximum Size Subarray Sum Equals k (maximum-size-subarray-sum-equals-k)
// Submission ID: 1657814004
// Language: java
// Timestamp (UTC): 2025-06-08T16:11:38Z

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int output = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        
        int currSum = 0;
        
        for(int i = 0; i<nums.length; i++){
            currSum+=nums[i];
             
            
            if(map.containsKey(currSum-k)){
                int len = i-map.get(currSum-k);
                output = Math.max(output,len);
            }
            
            if(!map.containsKey(currSum))map.put(currSum,i);
            
              
            
               
            
        }
        
        return output;
    }
}