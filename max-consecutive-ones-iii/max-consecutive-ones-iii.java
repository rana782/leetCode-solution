// LeetCode: Max Consecutive Ones III (max-consecutive-ones-iii)
// Submission ID: 1619308949
// Language: java
// Timestamp (UTC): 2025-04-27T12:23:17Z

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int j = 0;

        int output = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0)zeros++;

            while(j<=i && zeros>k){
                if(nums[j] == 0)zeros--;
                j++;
            }
            int len = i-j+1;

            output = Math.max(len,output);
        }

        return output;
    }
}