// LeetCode: Maximum Number of Moves in a Grid (maximum-number-of-moves-in-a-grid)
// Submission ID: 1508338584
// Language: java
// Timestamp (UTC): 2025-01-14T13:11:17Z

class Solution {
    public int maxMoves(int[][] grid) {
        int row = grid.length;
         int col = grid[0].length;
         int dir[][] = {{0,1},{-1,1},{1,1}};
         
         
         int dp[][] = new int[row][col];
         
         for(int j = col-1; j>=0; j--) {
        	 for(int i = 0; i<row; i++) {
        		 if(j == col-1) {
        			 dp[i][j] = 0;
        		 }
        		 
        		 else {
        			 int maxSteps = Integer.MIN_VALUE;
        			 
        			 for(int d[] : dir) {
        				 int nRow = i+d[0];
        				  int nCol = j+d[1];
        				  
        				  if(nRow>=0 && nRow<row && nCol>=0 && nCol<col && grid[i][j]<grid[nRow][nCol]) {
        					  maxSteps = Math.max(maxSteps, dp[nRow][nCol]);
        				  }
        			 }
        			 
        			 if(maxSteps == Integer.MIN_VALUE) dp[i][j] = 0;
        			 else {
        				 dp[i][j] = maxSteps+1;
        			 }
        			 
        		 }
        	 }
         }
         
         int output = 0;
         int j = 0;
         
         for(int i = 0; i<dp.length; i++) {
        	 output = Math.max(output, dp[i][j]);
         }
         
         return output;
    }
}