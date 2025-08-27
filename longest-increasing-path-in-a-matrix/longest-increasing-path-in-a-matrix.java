// LeetCode: Longest Increasing Path in a Matrix (longest-increasing-path-in-a-matrix)
// Submission ID: 1750197939
// Language: java
// Timestamp (UTC): 2025-08-27T13:32:26Z

class Solution {
    static int m, n;
    static int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        int overAllLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                overAllLength = Math.max(overAllLength, dfs(i, j, matrix, memo));
            }
        }
        return overAllLength;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];

        int maxPath = 1; // Start at length 1 (the current cell)
        for (int[] d : dir) {
            int nRow = i + d[0], nCol = j + d[1];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && matrix[nRow][nCol] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + dfs(nRow, nCol, matrix, memo));
            }
        }
        memo[i][j] = maxPath;
        return maxPath;
    }
}
