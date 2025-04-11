// LeetCode: Shortest Path in a Grid with Obstacles Elimination (shortest-path-in-a-grid-with-obstacles-elimination)
// Submission ID: 1603662721
// Language: java
// Timestamp (UTC): 2025-04-11T13:20:08Z

class Solution {
    static class Pair {
        int row, col, k, currDist;

        Pair(int row, int col, int k, int currDist) {
            this.row = row;
            this.col = col;
            this.k = k;
            this.currDist = currDist;
        }
    }

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, k, 0));

        while (!q.isEmpty()) {
            Pair rem = q.poll();

            if (rem.row == m - 1 && rem.col == n - 1) {
                return rem.currDist;
            }

            if (visited[rem.row][rem.col][rem.k]) continue;
            visited[rem.row][rem.col][rem.k] = true;

            for (int[] d : dir) {
                int nr = rem.row + d[0];
                int nc = rem.col + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (grid[nr][nc] == 0 && !visited[nr][nc][rem.k]) {
                        q.offer(new Pair(nr, nc, rem.k, rem.currDist + 1));
                    } else if (grid[nr][nc] == 1 && rem.k > 0 && !visited[nr][nc][rem.k - 1]) {
                        q.offer(new Pair(nr, nc, rem.k - 1, rem.currDist + 1));
                    }
                }
            }
        }

        return -1;
    }
}
