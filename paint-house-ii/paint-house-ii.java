// LeetCode: Paint House II (paint-house-ii)
// Submission ID: 1625135964
// Language: java
// Timestamp (UTC): 2025-05-04T09:23:37Z

class Solution {
    public int minCostII(int[][] costs) {
        int house = costs.length;
        int clr = costs[0].length;

        int matrix[][] = new int[clr][house];

        for(int j = 0; j<house; j++){
            for(int i = 0; i<clr; i++){

                if(j == 0){
                    matrix[i][j] = costs[j][i];
                }
                else{
                    int mini = Integer.MAX_VALUE;

                    for(int prevClr = 0; prevClr<clr; prevClr++){
                        if(prevClr!=i){
                            mini = Math.min(mini, matrix[prevClr][j-1]);
                        }
                    }

                    matrix[i][j] = mini+costs[j][i];
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i<clr; i++){
            res = Math.min(res,matrix[i][house-1]);
        }

        return res;
    }
}