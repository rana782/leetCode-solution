// LeetCode: Range Sum Query 2D - Immutable (range-sum-query-2d-immutable)
// Submission ID: 1518804209
// Language: java
// Timestamp (UTC): 2025-01-24T07:35:48Z

class NumMatrix {

   public int horizontalMatrix[][];

    public NumMatrix(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            int nums[] = matrix[i];

            for(int j = 1; j<nums.length; j++){
                nums[j]+=nums[j-1];
            }

            matrix[i] = nums;
        }

        this.horizontalMatrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int output = 0;

        for(int i = row1; i<=row2; i++){

            if(col1 == 0)output+=horizontalMatrix[i][col2];
            else{
                output+=(horizontalMatrix[i][col2]-horizontalMatrix[i][col1-1]);
            }
        }


        return output;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */