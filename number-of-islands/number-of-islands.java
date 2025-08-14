// LeetCode: Number of Islands (number-of-islands)
// Submission ID: 1735301018
// Language: java
// Timestamp (UTC): 2025-08-14T18:45:19Z

class Solution {
    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int m,n;

    public static void dfs(int i , int j, char grid[][], boolean visited[][]){
        visited[i][j] = true;

        for(int d[] : dir){
            int nRow = i+d[0];
            int nCol = j+d[1];

            if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && !visited[nRow][nCol] && grid[nRow][nCol] == '1'){
                dfs(nRow,nCol,grid,visited);
            }
        }

    }

    public int numIslands(char[][] grid) {
        m = grid.length;
         n = grid[0].length;
        int total_island = 0;
    
        boolean visited[][] = new boolean[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid,visited);
                    total_island++;
                }
            }
        }

        return total_island;
        
    }
}