// LeetCode: Check if Matrix Is X-Matrix (check-if-matrix-is-x-matrix)
// Submission ID: 1338345017
// Language: java
// Timestamp (UTC): 2024-07-30T11:13:04Z

class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i<row; i++){
            for(int j = 0 ; j<col; j++){
                if((i == j) || (i == row-j-1)){
                    if(grid[i][j] == 0){
                        return false;
                    }
                }
                else{
                    if(grid[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}