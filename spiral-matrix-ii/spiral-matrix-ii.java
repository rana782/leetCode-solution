// LeetCode: Spiral Matrix II (spiral-matrix-ii)
// Submission ID: 1604891672
// Language: java
// Timestamp (UTC): 2025-04-12T18:50:39Z

class Solution {
    public int[][] generateMatrix(int n) {
        int output[][] = new int[n][n];

        int limit = (n/2)-1;

        int num = 1;
        int itr = 0;

        while(itr<=limit){

            for(int col = itr; col<n-itr; col++){
                output[itr][col] = num;
                num++;
            }

            for(int row = itr+1; row<n-itr; row++){
                output[row][n-itr-1] = num;
                num++;
            }

            for(int col = n-itr-2; col>=itr; col--){
                output[n-itr-1][col] = num;
                num++;
            }

            for(int row = n-itr-2; row>itr; row--){
                output[row][itr] = num;
                num++;
            }
            itr++;
        }

         if (n % 2 == 1) {
            output[n / 2][n / 2] = num;
        }

        return output;
    }
}