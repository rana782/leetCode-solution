// LeetCode: Count Subarrays With Score Less Than K (count-subarrays-with-score-less-than-k)
// Submission ID: 1619976813
// Language: java
// Timestamp (UTC): 2025-04-28T06:42:44Z

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long sum = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum * (i - j + 1) >= k) {
                sum -= nums[j];
                j++;
            }
            ans += i - j + 1;
        }

        return ans;
    }

}