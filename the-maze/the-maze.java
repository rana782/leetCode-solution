// LeetCode: The Maze (the-maze)
// Submission ID: 1637202064
// Language: java
// Timestamp (UTC): 2025-05-18T10:25:16Z

class Solution {
    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public static class Pair{
        int row,col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        boolean visited[][] = new boolean[m][n];

        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(start[0],start[1]));

        while(q.size()!=0){
            int size = q.size();
            while(size-->0){
                Pair rem = q.poll();

                if(rem.row == destination[0] && rem.col == destination[1])return true;

                visited[rem.row][rem.col] = true;

                for(int d[] : dir){
                    int nRow = rem.row;
                     int nCol = rem.col;

                     while(nRow+d[0]>=0 && nCol+d[1]>=0 && nRow+d[0]<m && nCol+d[1]<n && maze[nRow+d[0]][nCol+d[1]]!=1){
                        nRow+=d[0];
                        nCol+=d[1];
                     }
                     if(!visited[nRow][nCol])q.add(new Pair(nRow,nCol));
                }
            }
        }

        return false;

    }
}