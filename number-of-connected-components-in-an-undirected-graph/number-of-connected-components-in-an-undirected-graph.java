// LeetCode: Number of Connected Components in an Undirected Graph (number-of-connected-components-in-an-undirected-graph)
// Submission ID: 1615017619
// Language: java
// Timestamp (UTC): 2025-04-22T20:48:45Z

class Solution {
    public static void dfs(int vertex,List<List<Integer>>graph,boolean visited[]){
            visited[vertex] = true;

            List<Integer>list = graph.get(vertex);

            for(int nbrs : list){
                if(!visited[nbrs]){
                    dfs(nbrs,graph,visited);
                }
            }

    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>>graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            int e[] = edges[i];
            int src = e[0];
            int dest = e[1];

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        boolean visited[] = new boolean[n];

        int output = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                output++;
            }
        }

        return output;
    }
}