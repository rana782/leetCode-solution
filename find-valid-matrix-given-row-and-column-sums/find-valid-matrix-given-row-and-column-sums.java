// LeetCode: Find Valid Matrix Given Row and Column Sums (find-valid-matrix-given-row-and-column-sums)
// Submission ID: 1609220065
// Language: java
// Timestamp (UTC): 2025-04-17T05:46:31Z

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int output[][] = new int[m][n];

        for(int i = 0; i<m; i++){
            Arrays.fill(output[i],0);
        }

        int i = 0;
        int j = 0;

        while(i<m && j<n){

            int mini = Math.min(rowSum[i],colSum[j]);

            output[i][j] = mini;

            rowSum[i]-=mini;
            colSum[j]-=mini;

            if(rowSum[i] == 0)i++;
            if(colSum[j] == 0)j++;
        }

        return output;
    }
}