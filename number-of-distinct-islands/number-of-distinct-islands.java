// LeetCode: Number of Distinct Islands (number-of-distinct-islands)
// Submission ID: 1614599302
// Language: java
// Timestamp (UTC): 2025-04-22T12:35:48Z

class Solution {
    static int m, n;

    public void dfs(int i, int j, int[][] grid, boolean[][] visited, StringBuilder path, char dir) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;
        path.append(dir);

        dfs(i + 1, j, grid, visited, path, 'd');
        dfs(i - 1, j, grid, visited, path, 'u');
        dfs(i, j + 1, grid, visited, path, 'r');
        dfs(i, j - 1, grid, visited, path, 'l');

        path.append('b'); // backtrack marker to differentiate shapes like T and L
    }

    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder path = new StringBuilder();
                    dfs(i, j, grid, visited, path, 'c'); // 'c' = origin

                    set.add(path.toString());
                }
            }
        }

        return set.size();
    }
}
