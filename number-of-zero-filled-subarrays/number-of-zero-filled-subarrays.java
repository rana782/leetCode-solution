// LeetCode: Number of Zero-Filled Subarrays (number-of-zero-filled-subarrays)
// Submission ID: 1604497089
// Language: java
// Timestamp (UTC): 2025-04-12T12:30:03Z

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int prevIdx = -1;
        int prefixSum = 0;

        long output = 0;

        for(int i = 0; i<nums.length; i++){
            if(prefixSum+nums[i] == prefixSum){
                output+=i-prevIdx;
            }
            else{
                prefixSum+=nums[i];
                prevIdx = i;
            }
        }

        return output;
    }
}