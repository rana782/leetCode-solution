// LeetCode: Number of Closed Islands (number-of-closed-islands)
// Submission ID: 1604535830
// Language: java
// Timestamp (UTC): 2025-04-12T13:28:36Z

class Solution {
    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int M,N;

    public static void dfs(int row, int col, int[][] grid, boolean[][] visited) {
        visited[row][col] = true;

        for (int[] d : dir) {
            int nRow = row + d[0];
            int nCol = col + d[1];

            if (nRow >= 0 && nCol >= 0 && nRow < M && nCol < N && grid[nRow][nCol] == 0 && !visited[nRow][nCol]) {
                dfs(nRow, nCol, grid, visited);
            }
        }
    }

    public int closedIsland(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        boolean[][] visited = new boolean[M][N];

        // Step 1: Eliminate border-connected lands
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if ((i == 0 || j == 0 || i == M - 1 || j == N - 1) && grid[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                }
            }
        }

        // Step 2: Count closed islands
        int output = 0;
        for (int i = 1; i < M - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    output++;
                }
            }
        }

        return output;
    }
}
