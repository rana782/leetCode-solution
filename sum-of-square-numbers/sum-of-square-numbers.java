// LeetCode: Sum of Square Numbers (sum-of-square-numbers)
// Submission ID: 1518032516
// Language: java
// Timestamp (UTC): 2025-01-23T14:28:57Z

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        int left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long sumOfSquares = (long) left * left + right * right;
            if (sumOfSquares == c) {
                return true;
            } else if (sumOfSquares > c) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }
}