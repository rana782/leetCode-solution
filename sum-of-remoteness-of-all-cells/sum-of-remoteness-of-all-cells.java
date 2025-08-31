// LeetCode: Sum of Remoteness of All Cells (sum-of-remoteness-of-all-cells)
// Submission ID: 1754447468
// Language: java
// Timestamp (UTC): 2025-08-31T06:51:42Z

class Solution {
    static int parent[];
    static int rank[];
    static int n;

    public static int find(int x){
        if(parent[x] == x)return x;

        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }

    public static boolean union(int x, int y){
        int lx = find(x);
         int ly = find(y);
         if(lx!=ly){

                if(rank[lx]>rank[ly]){
                    parent[ly] = lx;
                }
                else if(rank[lx]<rank[ly]){
                    parent[lx] = ly;
                }
                else{
                    parent[lx] = ly;
                    rank[ly]++;
                }

                return true;
         }
         return false;
    }
      static int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static  long dfs(int row, int col,boolean visited[][], int grid[][]){
           visited[row][col] = true;
           long sum = grid[row][col];
           int x = (row*n)+col;
            
            for(int d[] : dir){
                int nRow = row+d[0];
                 int nCol = col+d[1];
                 if(nRow>=0 && nCol>=0 && nRow<n && nCol<n &&!visited[nRow][nCol] && grid[nRow][nCol]!=-1){
                    int y = (nRow*n)+nCol;
                    union(x,y);
                    sum+=dfs(nRow,nCol,visited,grid);
                 }
            }

            return sum;
    }
    public long sumRemoteness(int[][] grid) {
        n = grid.length;
        parent = new int[n*n];
        rank = new int[n*n];

        for(int i = 0; i<n*n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        long totalSum = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]!=-1)totalSum+=grid[i][j];
            }
        }

        HashMap<Integer,Long>map = new HashMap<>();
        boolean visited[][] = new boolean[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                   long sum = 0;
                    if(grid[i][j]!=-1 && !visited[i][j]){
                     int code = (i*n)+j;
                     sum = dfs(i,j,visited,grid);
                     long rem = totalSum-sum;
                    int key = find(code);
                    map.put(key,rem);
                    }

                    
            }
        }

        long output = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                if(grid[i][j]!=-1){
                     int code = (i*n)+j;
                     output+=map.get(find(code));
                }
            }
        }

        return output;


    }
}