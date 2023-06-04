// LeetCode: Graph Valid Tree (graph-valid-tree)
// Submission ID: 1635062665
// Language: java
// Timestamp (UTC): 2025-05-15T22:13:36Z

class Solution {
   static int parent[];
    static int rank[];

     public static int find(int x){
        if(parent[x] == x)return x;

        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
     }

     public static boolean merge(int x, int y){
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

    public boolean validTree(int n, int[][] edges) {
     parent = new int[n];
      rank = new int[n];

      Arrays.fill(rank,1);
      for(int i = 0; i<n; i++){
        parent[i] = i;
      }

      for(int e[] : edges){
        int x = e[0];
        int y = e[1];

        if(!merge(x,y))return false;
      }

      for(int i = 0; i<n-1; i++){
        if(find(i)!=find(i+1))return false;
      }

      return true;



    }
}