// LeetCode: Redundant Connection (redundant-connection)
// Submission ID: 1524325065
// Language: java
// Timestamp (UTC): 2025-01-29T12:57:36Z

class Solution {
    static int[] parent;
	 static int[] rank;
	 
	 public static int find(int x) {
		 if(parent[x] == x) return x;
		 
		 int temp = find(parent[x]);
		  parent[x] = temp;
		  return temp;
	 }
	 
	 public static boolean union(int x, int y) {
		 
		 int lx = find(x);
		 int ly = find(y);
		 
		 if(lx!=ly) {
			 if(rank[lx]>rank[ly]) {
				 parent[ly] = lx;
			 }
			 
			 else if( rank[ly]>rank[lx]) {
				 parent[lx] = ly;
			 }
			 
			 else {
				 parent[lx] = ly;
				 rank[ly]++;
			 }
			 
			 return true;
		 }
		 
		 return false;
	 }
public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i = 0; i<parent.length; i++) {
        	parent[i] = i;
        	rank[i] = 1;
        }
        
        int output[] = new int[2];
        for( int e[] : edges) {
        	
        	if(!union(e[0], e[1])) {
        		output[0] = e[0];
        		output[1] = e[1];
        	}
        }
        
        return output;
    }
}