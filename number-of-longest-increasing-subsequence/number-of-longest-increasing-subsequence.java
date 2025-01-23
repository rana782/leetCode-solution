// LeetCode: Number of Longest Increasing Subsequence (number-of-longest-increasing-subsequence)
// Submission ID: 1517792255
// Language: java
// Timestamp (UTC): 2025-01-23T09:07:55Z

class Solution {
    	
public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];     // dp[i] = length of LIS ending at index i
        int[] count = new int[n]; // count[i] = number of LIS ending at index i
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLength = 1; // Overall maximum length of LIS

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; // Inherit count from j
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j]; // Add count from j
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        // Count all LIS with length = maxLength
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                totalCount += count[i];
            }
        }

        return totalCount;
    }
}