// LeetCode: Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit (longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit)
// Submission ID: 1663551797
// Language: java
// Timestamp (UTC): 2025-06-14T06:08:19Z

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer>map = new TreeMap<>();
         int output = 0;
        
        int i = 0;
         int j = 0;
        
        while(i<nums.length){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            
            while(j<=i && map.lastKey()-map.firstKey()>limit){
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j]) == 0)map.remove(nums[j]);
                j++;
            }
            
            int currLength = i-j+1;
            output = Math.max(currLength,output);
            i++;
        }
        
        return output;
    }
}