// LeetCode: Maximum Non Negative Product in a Matrix (maximum-non-negative-product-in-a-matrix)
// Submission ID: 1560358714
// Language: java
// Timestamp (UTC): 2025-03-02T12:49:50Z

class Solution {
  static final int MOD = 1_000_000_007;

    public static class Pair {
        long first, second;
        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Pair[][] dp = new Pair[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                long val = grid[i][j];

                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = new Pair(val, val);
                } else {
                    long maxProd = Long.MIN_VALUE, minProd = Long.MAX_VALUE;
                    
                    if (i + 1 < m) {
                        Pair down = dp[i + 1][j];
                        maxProd = Math.max(maxProd, Math.max(val * down.first, val * down.second));
                        minProd = Math.min(minProd, Math.min(val * down.first, val * down.second));
                    }
                    if (j + 1 < n) {
                        Pair right = dp[i][j + 1];
                        maxProd = Math.max(maxProd, Math.max(val * right.first, val * right.second));
                        minProd = Math.min(minProd, Math.min(val * right.first, val * right.second));
                    }

                    dp[i][j] = new Pair(maxProd, minProd);
                }
            }
        }

        long result = dp[0][0].first;
        return result < 0 ? -1 : (int) (result % MOD);
    }
}