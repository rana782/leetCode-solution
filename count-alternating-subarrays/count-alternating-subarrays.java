// LeetCode: Count Alternating Subarrays (count-alternating-subarrays)
// Submission ID: 1608946819
// Language: java
// Timestamp (UTC): 2025-04-16T21:16:56Z

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long output = 0;
        int idx = 0;

        while(idx<nums.length){
            int j = idx;

            while(j<nums.length-1){

                if(nums[j]!=nums[j+1])j++;
                else{
                    break;
                }
            }

            int len = j-idx+1;

            long curr = (long)len*(len+1)/2;
            output+=curr;

            idx = j+1;
        }

        return output;
    }
}