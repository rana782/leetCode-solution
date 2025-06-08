// LeetCode: Island Perimeter (island-perimeter)
// Submission ID: 1657968827
// Language: java
// Timestamp (UTC): 2025-06-08T19:11:58Z

class Solution {
    static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int m,n;
    public static int dfs(int i, int j, int grid[][]){
        grid[i][j] = -1;
        
        int points = 0;
        
        for(int d[] : dir){
            int nRow = i+d[0];
            int nCol = j+d[1];
            
           if(nRow<0 || nCol<0 || nRow>=m || nCol>=n || grid[nRow][nCol] == 0)points++;
            else if(grid[nRow][nCol] == 1)points+=dfs(nRow,nCol,grid);
        }
        
        return points;
    }
    public int islandPerimeter(int[][] grid) {
        int output = 0;
        m = grid.length;
        n = grid[0].length;
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    output = dfs(i,j,grid);
                    break;
                }
            }
        }
        
        return output;
        
        
    }
}