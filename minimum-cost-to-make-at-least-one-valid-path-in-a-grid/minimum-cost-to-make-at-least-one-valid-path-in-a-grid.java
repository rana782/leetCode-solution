// LeetCode: Minimum Cost to Make at Least One Valid Path in a Grid (minimum-cost-to-make-at-least-one-valid-path-in-a-grid)
// Submission ID: 1752373232
// Language: java
// Timestamp (UTC): 2025-08-29T11:59:16Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int nbr,cost;

        Pair(int nbr, int cost){
            this.nbr = nbr;
            this.cost = cost;
        }

        public int compareTo(Pair o){
            return this.cost-o.cost;
        }

    }

 

    static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        ArrayList<ArrayList<Pair>>graph = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i<m*n; i++){
            graph.add(new ArrayList<>());
        }

        for(int row = 0; row<m; row++){
            for(int col = 0; col<n; col++){

                int node = (row*n)+col;
                int dirInt = grid[row][col];

                for(int i = 0; i<4; i++){
                    int arr[] = dir[i];

                    int nRow = row+arr[0];
                    int nCol = col+arr[1];

                    if(nRow>=0 && nCol>=0 && nRow<m && nCol<n){
                        int nbrNode = (nRow*n)+nCol;
                        if(i == dirInt-1){
                            graph.get(node).add(new Pair(nbrNode,0));
                        }
                        else{
                            graph.get(node).add(new Pair(nbrNode,1));
                        }
                    }
                }
            }
        }



        int src = 0;
         int dest = (m*n)-1;
         int dist[] = new int[m*n];
         Arrays.fill(dist,Integer.MAX_VALUE);

        

        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.nbr == dest)return p.cost;

            for(Pair nbrs : graph.get(p.nbr)){
                if(nbrs.cost+p.cost<dist[nbrs.nbr]){
                    dist[nbrs.nbr] = nbrs.cost+p.cost;
                    pq.add(new Pair(nbrs.nbr,nbrs.cost+p.cost));
                }
            }

        }

        return 0;



    }
}