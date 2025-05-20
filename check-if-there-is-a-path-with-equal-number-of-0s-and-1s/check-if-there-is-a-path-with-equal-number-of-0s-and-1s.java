// LeetCode: Check if There is a Path With Equal Number of 0's And 1's (check-if-there-is-a-path-with-equal-number-of-0s-and-1s)
// Submission ID: 1639208878
// Language: java
// Timestamp (UTC): 2025-05-20T10:49:24Z

class Solution {
    static int m,n;
    static int dir[][] = {{1,0},{0,1}};
    static HashMap<String,Boolean>memo;
    public static boolean solution(int i, int j, int ones, int zero, int grid[][]){
        if(i == m-1 && j == n-1){
            if(ones == zero)return true;

            return false;
        }
        String code = i+"_"+j+"_"+"_"+ones+"_"+zero;
        if(memo.containsKey(code))return memo.get(code);

        boolean ans = false;

        for(int d[] : dir){
            int nRow = i+d[0];
            int nCol = j+d[1];

            if(nRow>=0 && nCol>=0 && nRow<m && nCol<n){
                if(grid[nRow][nCol] ==1){
                    ans|=solution(nRow,nCol,ones+1,zero,grid);
                }
                else{
                    ans|=solution(nRow,nCol,ones,zero+1,grid);
                }
            }

           
        }

        memo.put(code,ans);

         return ans;


    }
    public boolean isThereAPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new HashMap<>();


      if (grid[0][0] == 1)
    return solution(0, 0, 1, 0, grid);
else
    return solution(0, 0, 0, 1, grid);


    }
}