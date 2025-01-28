// LeetCode: All Ancestors of a Node in a Directed Acyclic Graph (all-ancestors-of-a-node-in-a-directed-acyclic-graph)
// Submission ID: 1523309151
// Language: java
// Timestamp (UTC): 2025-01-28T14:12:15Z

class Solution {

    public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, List<Integer> subAns,boolean visited[]){
        visited[src] = true;
        for(int nbrs : graph.get(src)){
            if(!visited[nbrs]){
                  subAns.add(nbrs);
            dfs(graph,nbrs,subAns,visited);
            }
            
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int e[] : edges){

            graph.get(e[1]).add(e[0]);
        }


        List<List<Integer>> output = new ArrayList<>();

        for(int i =0; i<n; i++){
            List<Integer> subAns = new ArrayList<>();
            boolean visited[] = new boolean[n];
            dfs(graph, i, subAns,visited);

            Collections.sort(subAns);
            output.add(subAns);
        }

        return output;
    }

}