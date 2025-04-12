// LeetCode: Count Negative Numbers in a Sorted Matrix (count-negative-numbers-in-a-sorted-matrix)
// Submission ID: 1604899039
// Language: java
// Timestamp (UTC): 2025-04-12T18:59:51Z

class Solution {
    public int countNegatives(int[][] grid) {
        int count  = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j]<0)count++;
            }
        }

        return count;
    }
}