// LeetCode: Longest Subarray of 1's After Deleting One Element (longest-subarray-of-1s-after-deleting-one-element)
// Submission ID: 1619337470
// Language: java
// Timestamp (UTC): 2025-04-27T13:05:24Z

class Solution {
    public int longestSubarray(int[] nums) {
        int output = 0;
        int j = 0;
        int zeros = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0)zeros++;

            while(j<=i && zeros>1){
                if(nums[j] == 0)zeros--;
                j++;
            }

            int len = i-j+1;
            output = Math.max(len,output);
        }

        return output == 0 ? 0 : output-1;
    }
}