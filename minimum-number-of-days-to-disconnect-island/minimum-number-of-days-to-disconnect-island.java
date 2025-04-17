// LeetCode: Minimum Number of Days to Disconnect Island (minimum-number-of-days-to-disconnect-island)
// Submission ID: 1609436253
// Language: java
// Timestamp (UTC): 2025-04-17T10:25:00Z

class Solution {
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int m, n;

    public boolean isDisconnected(int[][] grid) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    if(count == 1) return true; // more than 1 island
                    dfs(i, j, visited, grid);
                    count++;
                }
            }
        }

        return count != 1; // disconnected if 0 or more than 1 island
    }

    public void dfs(int i, int j, boolean[][] visited, int[][] grid) {
        visited[i][j] = true;

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1 && !visited[ni][nj]){
                dfs(ni, nj, visited, grid);
            }
        }
    }

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if(isDisconnected(grid)) return 0;

        // Try removing one cell
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(isDisconnected(grid)) return 1;
                    grid[i][j] = 1; // restore
                }
            }
        }

        return 2;
    }
}
