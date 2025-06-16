// LeetCode: Rotting Oranges (rotting-oranges)
// Submission ID: 1666561426
// Language: java
// Timestamp (UTC): 2025-06-16T23:38:33Z

class Solution {
    
        public static class Pair{
            int row,col;
            
            Pair(int row, int col){
                this.row = row;
                this.col =col;
            }
        }
    public int orangesRotting(int[][] grid) {
        
        
        int freshOrange = 0;
        
        Queue<Pair>q = new LinkedList<>();
        
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        
        int m = grid.length;
         int n = grid[0].length;
        
        
        for(int i = 0;i<m; i++){
            for(int j = 0; j<n; j++){
                
                if(grid[i][j] == 1)freshOrange++;
                else if(grid[i][j] == 2)q.add(new Pair(i,j));
            }
        }
        
        if(freshOrange == 0)return 0;
        
        int timeElapsed = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                Pair rem = q.poll();
                
                for(int d[] : dir){
                    int nRow = rem.row+d[0];
                    int nCol = rem.col+d[1];
                    
                    if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && grid[nRow][nCol] == 1){
                        freshOrange--;
                        grid[nRow][nCol] = 2;
                        q.add(new Pair(nRow,nCol));
                    }
                }
            }
            timeElapsed++;
        }
        
        return freshOrange == 0 ? timeElapsed-1 : -1;
    }
}