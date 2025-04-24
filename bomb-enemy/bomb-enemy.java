// LeetCode: Bomb Enemy (bomb-enemy)
// Submission ID: 1616676818
// Language: java
// Timestamp (UTC): 2025-04-24T13:31:32Z

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
        int maxi = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                
                if(grid[i][j] == '0'){
                    int curr =0;
                    

                    for(int d[] : dir){
                        int iInc = d[0];
                        int jInc = d[1];

                        int currI = i+iInc;
                         int currJ = j+jInc;

                        while(currI>=0 && currJ>=0 && currI<m && currJ<n){
                            if(grid[currI][currJ] == 'W')break;

                            if(grid[currI][currJ] == 'E')curr++;

                            currI+=iInc;
                            currJ+=jInc;
                        }
                    }

                    maxi = Math.max(maxi,curr);
                }
            }
        }

        return maxi;

    }
}