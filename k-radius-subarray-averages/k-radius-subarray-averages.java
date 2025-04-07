// LeetCode: K Radius Subarray Averages (k-radius-subarray-averages)
// Submission ID: 1599612651
// Language: java
// Timestamp (UTC): 2025-04-07T14:13:12Z

class Solution {
  public int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);

    int windowSize = 2 * k + 1;
    if (windowSize > n) return res;

    long sum = 0;
    for (int i = 0; i < windowSize; i++) {
        sum += nums[i];
    }

    res[k] = (int)(sum / windowSize);

    for (int i = windowSize; i < n; i++) {
        sum += nums[i] - nums[i - windowSize];
        res[i - k] = (int)(sum / windowSize);
    }

    return res;
}

}