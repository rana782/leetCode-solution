// LeetCode: Count Sub Islands (count-sub-islands)
// Submission ID: 1609477206
// Language: java
// Timestamp (UTC): 2025-04-17T11:25:23Z

public class Solution {
    public static class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return row == p.row && col == p.col;
        }

        @Override
        public int hashCode() {
            return 31 * row + col;
        }
    }

    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    static int m, n;
    static boolean subIsland;

    public static void dfs1(int i, int j, boolean[][] visited, int[][] grid, HashSet<Pair> set) {
        set.add(new Pair(i, j));
        visited[i][j] = true;

        for (int[] d : dir) {
            int nRow = i + d[0], nCol = j + d[1];
            if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs1(nRow, nCol, visited, grid, set);
            }
        }
    }

    private void dfs2(int i, int j, boolean[][] visited, int[][] grid2, HashSet<Pair> set) {
        if (!set.contains(new Pair(i, j))) subIsland = false;
        visited[i][j] = true;

        for (int[] d : dir) {
            int nRow = i + d[0], nCol = j + d[1];
            if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && !visited[nRow][nCol] && grid2[nRow][nCol] == 1) {
                dfs2(nRow, nCol, visited, grid2, set);
            }
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        HashSet<Pair> set = new HashSet<>();
        m = grid1.length;
        n = grid1[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j] && grid1[i][j] == 1)
                    dfs1(i, j, visited, grid1, set);

        int count = 0;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    subIsland = true;
                    dfs2(i, j, visited, grid2, set);
                    if (subIsland) count++;
                }

        return count;
    }
}
