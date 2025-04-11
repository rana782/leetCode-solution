// LeetCode: Where Will the Ball Fall (where-will-the-ball-fall)
// Submission ID: 1603857857
// Language: java
// Timestamp (UTC): 2025-04-11T17:21:47Z

class Solution {
        static int M;
        static int N;
        static int colAns;
    public static boolean solution(int row, int col, int grid[][]){
        if(row>=M && col>=0 && col<N) {
            colAns = col;
            return true;
        }

        boolean ans = false;

        if(grid[row][col] == 1 && col+1<N && grid[row][col+1] == 1){
            ans = solution(row+1,col+1,grid);
        }

        else if(grid[row][col] == -1 && col-1>=0 && grid[row][col-1] == -1){
            ans = solution(row+1,col-1,grid);
        }

        return ans;
    }
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        M = m;
        N = n;

        int output[] = new int[n];
        Arrays.fill(output,-1);

        for(int i = 0; i<n; i++){

            if(solution(0,i,grid))output[i] = colAns;
        }

        return output;
    }
}