// LeetCode: Reach a Number (reach-a-number)
// Submission ID: 1556140661
// Language: java
// Timestamp (UTC): 2025-02-26T14:20:09Z

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}