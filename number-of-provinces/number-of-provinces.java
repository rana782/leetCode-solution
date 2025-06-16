// LeetCode: Number of Provinces (number-of-provinces)
// Submission ID: 1665566694
// Language: java
// Timestamp (UTC): 2025-06-16T04:28:40Z

class Solution {
    static int parent[];
    static int rank[];
    
    public static int find(int x){
        if(parent[x] == x)return x;
        
        int temp = find(parent[x]);
        parent[x]= temp;
        return temp;
    }
    
    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx!=ly){
            if(rank[lx]>rank[ly]){
                parent[ly] = lx;
                
            }else if(rank[ly]>rank[lx]){
                parent[lx] = ly;
                
            }
            else{
                parent[lx] =ly;
                rank[ly]++;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(isConnected[i][j] == 1){
                    union(i+1,j+1);
                }
            }
        }
        
        int output = 0;
        
        for(int i = 1; i<parent.length; i++){
            if(parent[i] == i)output++;
        }
        
        return output;
    }
}