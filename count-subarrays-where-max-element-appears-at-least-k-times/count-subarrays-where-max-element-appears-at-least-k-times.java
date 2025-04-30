// LeetCode: Count Subarrays Where Max Element Appears at Least K Times (count-subarrays-where-max-element-appears-at-least-k-times)
// Submission ID: 1622128267
// Language: java
// Timestamp (UTC): 2025-04-30T16:55:50Z

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxEle = 0;

        for(int ele : nums){
            maxEle = Math.max(maxEle,ele);
        }

        long total = (long)n*(n+1)/2;

        long minus = 0;
        long count = 0;

        int start = 0;
        for(int end = 0; end<nums.length; end++){
            if(nums[end] == maxEle)count++;

            while(start<=end && count>=k){
                if(nums[start] == maxEle)count--;
                start++;
            }

            minus+=end-start+1;
        }

        return total-minus;
    }
}