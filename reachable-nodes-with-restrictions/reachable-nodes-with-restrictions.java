// LeetCode: Reachable Nodes With Restrictions (reachable-nodes-with-restrictions)
// Submission ID: 1752408303
// Language: java
// Timestamp (UTC): 2025-08-29T12:42:54Z

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int e[] : edges){
            int src = e[0];
             int dest = e[1];

             graph.get(src).add(dest);
             graph.get(dest).add(src);
        }

        int count = 0;

        HashSet<Integer>set = new HashSet<>();

        for(int ele : restricted){
            set.add(ele);
        }

        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        boolean visited[] = new boolean[n];

        Arrays.fill(visited,false);

        while(!q.isEmpty()){
            int src = q.poll();
            visited[src] = true;
            count++;
            for(int nbrs : graph.get(src)){
                if(!set.contains(nbrs) && !visited[nbrs])q.add(nbrs);
            }
        }

        return count;
    }
}