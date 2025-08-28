// LeetCode: Sort Matrix by Diagonals (sort-matrix-by-diagonals)
// Submission ID: 1750796804
// Language: java
// Timestamp (UTC): 2025-08-28T02:41:41Z

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for(int row = 0; row<n; row++){
            PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int col = 0; col<n-row; col++){
                pq.add(grid[row+col][col]);
            }

            for(int col = 0; col<n-row; col++){
                grid[row+col][col] =  pq.poll();
            }
        }


        for(int col = 1; col<n; col++){
            PriorityQueue<Integer>pq = new PriorityQueue<>();
            for(int row = 0; row<n-col; row++){
                pq.add(grid[row][col+row]);
            }

            for(int row = 0; row<n-col; row++){
                grid[row][col+row] = pq.poll();
            }
        }

        return grid;
    }
}