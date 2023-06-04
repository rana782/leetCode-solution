// LeetCode: Sparse Matrix Multiplication (sparse-matrix-multiplication)
// Submission ID: 1634729340
// Language: java
// Timestamp (UTC): 2025-05-15T14:34:51Z

class Solution {
    public static int find(int i, int j, int mat1[][], int mat2[][]){
        int output = 0;

        for(int move = 0; move<mat1[0].length; move++){
            int currSum = mat1[i][move]*mat2[move][j];
            output+=currSum;
        }

        return output;
    }
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;

        int output[][] = new int[m][n];

        for(int i = 0; i<output.length; i++){
            for(int j = 0; j<output[0].length; j++){

                output[i][j] = find(i,j,mat1,mat2);
            }
        }

        return output;
    }
}