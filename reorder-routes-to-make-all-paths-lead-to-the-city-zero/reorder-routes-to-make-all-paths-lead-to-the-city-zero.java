// LeetCode: Reorder Routes to Make All Paths Lead to the City Zero (reorder-routes-to-make-all-paths-lead-to-the-city-zero)
// Submission ID: 1670020606
// Language: java
// Timestamp (UTC): 2025-06-20T02:54:09Z

class Solution {
    public static class Pair{
        int dest,cost;
        Pair(int dest,int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    public static int dfs(int vertex, List<List<Pair>>graph,boolean visited[]){
        visited[vertex] = true;
        int cost = 0;
        
        for(Pair p : graph.get(vertex)){
            if(!visited[p.dest]){
                cost+=p.cost+dfs(p.dest,graph,visited);
            }
        }
        
        return cost;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Pair>>graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int c[] : connections){
            graph.get(c[0]).add(new Pair(c[1],1));
            graph.get(c[1]).add(new Pair(c[0],0));
        }
        
        
        boolean visited[] = new boolean[n];
        
        return dfs(0,graph,visited);
    }
}