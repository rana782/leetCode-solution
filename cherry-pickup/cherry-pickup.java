// LeetCode: Cherry Pickup (cherry-pickup)
// Submission ID: 1752473214
// Language: java
// Timestamp (UTC): 2025-08-29T13:53:28Z

class Solution {
    int n;
    int[][] grid;
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        dp = new int[n][n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    dp[i][j][k] = Integer.MIN_VALUE;
        
        int res = Math.max(0, dfs(0, 0, 0));
        return res;
    }

    private int dfs(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        if (dp[r1][c1][c2] != Integer.MIN_VALUE)
            return dp[r1][c1][c2];

        int cherries = grid[r1][c1];
        
        if (c1 != c2 || r1 != r2)
            cherries += grid[r2][c2];

        int temp = Math.max(
            Math.max(dfs(r1, c1 + 1, c2 + 1), dfs(r1 + 1, c1, c2 + 1)),
            Math.max(dfs(r1, c1 + 1, c2), dfs(r1 + 1, c1, c2))
        );

        cherries += temp;
        dp[r1][c1][c2] = cherries;

        return cherries;
    }
}
