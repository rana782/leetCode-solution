// LeetCode: Path Existence Queries in a Graph I (path-existence-queries-in-a-graph-i)
// Submission ID: 1640634747
// Language: java
// Timestamp (UTC): 2025-05-21T19:33:42Z

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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i<nums.length-1; i++){
            if(Math.abs(nums[i]-nums[i+1])<=maxDiff)union(i,i+1);
        }

        boolean output[] = new boolean[queries.length];
        int idx = 0;

        for(int q[] : queries){
            int i = q[0]; 
            int j = q[1];

            output[idx++] = find(i) == find(j);
        }

        return output;

    }
}