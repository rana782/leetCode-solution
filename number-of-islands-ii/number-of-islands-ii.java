// LeetCode: Number of Islands II (number-of-islands-ii)
// Submission ID: 1639646021
// Language: java
// Timestamp (UTC): 2025-05-20T19:13:51Z

class Solution {
    static int parent[]; 
   static  int rank[];

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
        else if(rank[ly]>rank[lx]){
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
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        parent = new int[m*n];
        rank = new int[m*n];

        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int matrix[][] = new int[m][n];
       
        List<Integer>output = new ArrayList<>();
        HashSet<String>set = new HashSet<>();
       

        for(int i =0; i<matrix.length; i++){
            Arrays.fill(matrix[i],0);
        }

        int ans = 0;
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0; i<positions.length; i++){
            int r = positions[i][0];
            int c = positions[i][1];
            String code = r+"_"+c;
            if(set.contains(code)){
                output.add(ans);
                continue;
            }

         

            set.add(code);
            matrix[r][c] = 1;
            ans++;

            for(int d[] : dir){
                int nRow = r+d[0];
                int nCol = c+d[1];

                if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && matrix[nRow][nCol] == 1){
                    int pos1 = (nRow*n)+nCol;
                    int pos2 = (r*n)+c;

                    if(union(pos1,pos2))ans--;
                }
            }
            
            output.add(ans);

            


        }

        return output;
    }
}