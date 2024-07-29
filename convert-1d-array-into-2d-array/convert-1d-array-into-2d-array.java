// LeetCode: Convert 1D Array Into 2D Array (convert-1d-array-into-2d-array)
// Submission ID: 1337608536
// Language: java
// Timestamp (UTC): 2024-07-29T18:09:31Z

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
       

        if(m*n!=original.length){
          return new int[0][0];
        }
         int output[][] = new int[m][n];
int k =0;
        for(int i =0; i<output.length; i++){
            for(int j = 0; j<output[0].length; j++){
                output[i][j] = original[k++];
            }
        }
        return output;
    }
}