// LeetCode: Count Subarrays of Length Three With a Condition (count-subarrays-of-length-three-with-a-condition)
// Submission ID: 1619184036
// Language: java
// Timestamp (UTC): 2025-04-27T09:12:27Z

class Solution {
    public int countSubarrays(int[] nums) {
        int output = 0;

        int right = 2;
        int left = 0;
         int middle = 1;

         while(right<nums.length){
            if((double)(nums[right]+nums[left]) == (double)nums[middle]/2.0)output++;
            

            right++;
            left++;
            middle++;

         }

         return output;
    }
}