// LeetCode: The Maze II (the-maze-ii)
// Submission ID: 1637223041
// Language: java
// Timestamp (UTC): 2025-05-18T10:58:29Z

class Solution {
    public static class Pair {
        int row, col, dist;
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start[0], start[1], 0));

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            for (int[] d : dir) {
                int nRow = rem.row, nCol = rem.col, count = 0;
                while (nRow + d[0] >= 0 && nRow + d[0] < m && nCol + d[1] >= 0 && nCol + d[1] < n
                        && maze[nRow + d[0]][nCol + d[1]] == 0) {
                    nRow += d[0];
                    nCol += d[1];
                    count++;
                }
                if (rem.dist + count < dist[nRow][nCol]) {
                    dist[nRow][nCol] = rem.dist + count;
                    q.add(new Pair(nRow, nCol, dist[nRow][nCol]));
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}
