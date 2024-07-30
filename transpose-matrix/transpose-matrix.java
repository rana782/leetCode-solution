// LeetCode: Transpose Matrix (transpose-matrix)
// Submission ID: 1338132379
// Language: java
// Timestamp (UTC): 2024-07-30T06:59:36Z

class Solution {
    public int[][] transpose(int[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;

      int transposed[][] = new int[col][row];

      for(int i =0; i<row; i++){
        for(int j = 0; j<col; j++){
            transposed[j][i] = matrix[i][j];
        }
      }
      return transposed;
    }
}