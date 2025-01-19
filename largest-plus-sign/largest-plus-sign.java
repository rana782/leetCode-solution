// LeetCode: Largest Plus Sign (largest-plus-sign)
// Submission ID: 1513256342
// Language: java
// Timestamp (UTC): 2025-01-19T06:02:24Z

class Solution {
public int orderOfLargestPlusSign(int n, int[][] mines) {
    int[][] leftMax = new int[n][n];
    int[][] rightMax = new int[n][n];
    int[][] upMax = new int[n][n];
    int[][] downMax = new int[n][n];

    int[][] grid = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            grid[i][j] = 1; // Initially, all cells are 1
        }
    }

    for (int[] mine : mines) {
        grid[mine[0]][mine[1]] = 0; // Mark mined cells as 0
    }

    // Fill leftMax
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                leftMax[i][j] = (j == 0) ? 1 : leftMax[i][j - 1] + 1;
            }
        }
    }

    // Fill rightMax
    for (int i = 0; i < n; i++) {
        for (int j = n - 1; j >= 0; j--) {
            if (grid[i][j] == 1) {
                rightMax[i][j] = (j == n - 1) ? 1 : rightMax[i][j + 1] + 1;
            }
        }
    }

    // Fill upMax
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < n; i++) {
            if (grid[i][j] == 1) {
                upMax[i][j] = (i == 0) ? 1 : upMax[i - 1][j] + 1;
            }
        }
    }

    // Fill downMax
    for (int j = 0; j < n; j++) {
        for (int i = n - 1; i >= 0; i--) {
            if (grid[i][j] == 1) {
                downMax[i][j] = (i == n - 1) ? 1 : downMax[i + 1][j] + 1;
            }
        }
    }

    int output = 0;
    // Calculate the largest plus sign
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                int currentMax = Math.min(
                    Math.min(leftMax[i][j], rightMax[i][j]),
                    Math.min(upMax[i][j], downMax[i][j])
                );
                output = Math.max(output, currentMax);
            }
        }
    }

    return output;
}

}