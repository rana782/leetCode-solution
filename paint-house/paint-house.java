// LeetCode: Paint House (paint-house)
// Submission ID: 1623812189
// Language: java
// Timestamp (UTC): 2025-05-02T17:44:45Z

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int output[][] = new int[3][n];
        for(int j = 0; j<n; j++){
            for(int i = 0; i<3; i++){
                if(j == 0){
                    output[i][j] = costs[j][i];
                }
                else{
                    if(i == 0){
                        output[i][j] = costs[j][i]+Math.min(output[i+1][j-1],output[i+2][j-1]);
                    }
                    else if(i == 1){
                        output[i][j] = costs[j][i]+Math.min(output[i-1][j-1],output[i+1][j-1]);
                    }
                    else{
                        output[i][j] = costs[j][i]+Math.min(output[i-1][j-1],output[i-2][j-1]);
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i<3; i++){
            res = Math.min(res, output[i][n-1]);
        }
        return res;
    }
}