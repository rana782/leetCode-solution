// LeetCode: Maximum Number of Fish in a Grid (maximum-number-of-fish-in-a-grid)
// Submission ID: 1523118378
// Language: java
// Timestamp (UTC): 2025-01-28T10:07:28Z

class Solution {
    static int currSum;
  static  int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void dfs(int grid[][], int i, int j){
        currSum+=grid[i][j];
        grid[i][j] = 0;

        for(int d[] : dir){
            int nRow = i+d[0];
            int nCol = j+d[1];


            if(nRow>=0 && nCol>=0 && nRow<grid.length && nCol<grid[0].length && grid[nRow][nCol]!=0){
                dfs(grid,nRow,nCol);
            }
        }
    }
    public int findMaxFish(int[][] grid) {
        int output = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){

                if(grid[i][j]!=0){
                    currSum = 0;
                    dfs(grid,i,j);
                    output = Math.max(output,currSum);
                }
            }
        }

        return output;
    }
}