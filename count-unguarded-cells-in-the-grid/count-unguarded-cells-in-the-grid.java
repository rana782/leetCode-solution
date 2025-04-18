// LeetCode: Count Unguarded Cells in the Grid (count-unguarded-cells-in-the-grid)
// Submission ID: 1610518193
// Language: java
// Timestamp (UTC): 2025-04-18T13:06:48Z

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2; // Wall
        }

        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1; // Guard
        }

        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for (int[] g : guards) {
            for (int[] dir : dirs) {
                int i = g[0] + dir[0];
                int j = g[1] + dir[1];

                while (i >= 0 && i < m && j >= 0 && j < n) {
                    if (grid[i][j] == 1 || grid[i][j] == 2) break; // Stop at guard or wall
                    if (grid[i][j] == 0) grid[i][j] = 3; // Mark as watched
                    i += dir[0];
                    j += dir[1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++; // Only unguarded and unwatched
            }
        }

        return count;
    }
}
