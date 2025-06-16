// LeetCode: Missing Ranges (missing-ranges)
// Submission ID: 1665456443
// Language: java
// Timestamp (UTC): 2025-06-16T01:27:11Z

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>>output = new ArrayList<>();
        if(nums.length == 0){
            output.add(Arrays.asList(lower,upper));
            
            return output;
        }
        
        if(upper == lower){
            return output;
        }
            
        int s = lower;
         int e = nums[0]-1;
        
        if(e>=s)output.add(Arrays.asList(s,e));
        
        for(int i = 0; i<nums.length-1; i++){
        
            s = nums[i]+1;
            e = nums[i+1]-1;
            
            if(e>=s)output.add(Arrays.asList(s,e));
            }
        
        
        s = nums[nums.length-1]+1;
        e = upper;
        
        if(e>=s)output.add(Arrays.asList(s,e));
        System.out.println(output);
        
        return output;
        
        
    }
}