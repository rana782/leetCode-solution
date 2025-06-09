// LeetCode: Subarray Sum Equals K (subarray-sum-equals-k)
// Submission ID: 1658989745
// Language: java
// Timestamp (UTC): 2025-06-09T18:52:24Z

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        
        int currSum = 0;
        int output = 0;
        
        for(int ele : nums){
            currSum+=ele;
            
            if(map.containsKey(currSum-k)){
                output+=map.get(currSum-k);
            }
            
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        
        return output;
    }
}