// LeetCode: Difference Between Ones and Zeros in Row and Column (difference-between-ones-and-zeros-in-row-and-column)
// Submission ID: 1607734409
// Language: java
// Timestamp (UTC): 2025-04-15T16:41:01Z

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int zeroRow[] = new int[m];
         int oneRow[] = new int[m];
          int zeroCol[] = new int[n];
          int oneCol[] = new int[n];

          for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){

                if(grid[i][j] == 0){
                    zeroRow[i]++;
                }
                else{
                    oneRow[i]++;
                }
            }
          }

          for(int j = 0; j<n; j++){
            for(int i = 0; i<m; i++){

                if(grid[i][j] == 0){
                    zeroCol[j]++;
                }
                else{
                    oneCol[j]++;
                }
            }
          }


          int output[][] = new int[m][n];

          for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){

                output[i][j] = oneRow[i]+oneCol[j]-zeroRow[i]-zeroCol[j];
            }
          }

          return output;
    }
}