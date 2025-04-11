// LeetCode: Minimum Average Difference (minimum-average-difference)
// Submission ID: 1603893671
// Language: java
// Timestamp (UTC): 2025-04-11T17:59:34Z

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) totalSum += num;

        long leftSum = 0;
        int minDiff = Integer.MAX_VALUE;
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;

            long leftAvg = leftSum / (i + 1);
            long rightAvg = (i == n - 1) ? 0 : rightSum / (n - i - 1);

            int diff = (int)Math.abs(leftAvg - rightAvg);
            if (diff < minDiff) {
                minDiff = diff;
                resultIndex = i;
            }
        }

        return resultIndex;
    }
}
