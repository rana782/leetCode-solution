// LeetCode: Max Consecutive Ones II (max-consecutive-ones-ii)
// Submission ID: 1619278986
// Language: java
// Timestamp (UTC): 2025-04-27T11:37:27Z

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0;
        int j = 0;

        int zeros = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0)zeros++;

            while(j<=i && zeros>1){
                if(nums[j] == 0)zeros--;
                j++;
            }

            len = Math.max(len,i-j+1);
        }

        return len;

    }
}