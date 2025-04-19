// LeetCode: Connecting Cities With Minimum Cost (connecting-cities-with-minimum-cost)
// Submission ID: 1611883358
// Language: java
// Timestamp (UTC): 2025-04-19T21:44:29Z

class Solution {
    static int parent[]; 
    static int rank[];

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
    public int minimumCost(int n, int[][] connections) {
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }

        Arrays.fill(rank,1);

        Arrays.sort(connections,(a,b)->Integer.compare(a[2], b[2]));

        int mearged = 0;
        int cost = 0;

        for(int i = 0; i<connections.length; i++){
            int arr[] = connections[i];

            int x = arr[0];
             int y = arr[1];
             int wt = arr[2];

             if(union(x, y)){
                mearged++;
                cost+=wt;

                if(mearged == n-1)return cost;
             }
        }

        return -1;
    }
}