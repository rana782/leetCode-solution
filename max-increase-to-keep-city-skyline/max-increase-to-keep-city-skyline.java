// LeetCode: Max Increase to Keep City Skyline (max-increase-to-keep-city-skyline)
// Submission ID: 1756569879
// Language: java
// Timestamp (UTC): 2025-09-02T04:08:44Z

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        HashMap<Integer,Integer>rowMax = new HashMap<>();
        HashMap<Integer,Integer>colMax = new HashMap<>();
        int n = grid.length;

      for(int i = 0; i<n; i++){
        int maxi = Integer.MIN_VALUE;

        for(int j=0; j<n; j++){
            maxi = Math.max(maxi,grid[i][j]);
        }
        rowMax.put(i,maxi);
      }

      //finidng column max;

      for(int j = 0; j<n; j++){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            maxi = Math.max(maxi,grid[i][j]);
        }

        colMax.put(j,maxi);
      }

int output = 0;
      for(int i = 0; i<n; i++){
        int rowMaxi = rowMax.get(i);
        for(int j = 0; j<n; j++){
            int ans = Math.min(rowMaxi,colMax.get(j));
            output+=Math.abs(grid[i][j]-ans);
        }
      }

      return output;

    }
}