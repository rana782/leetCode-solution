// LeetCode: Network Delay Time (network-delay-time)
// Submission ID: 1671033156
// Language: java
// Timestamp (UTC): 2025-06-21T01:59:36Z

class Solution {
    public class Pair implements Comparable<Pair>{
        int dest,timeTaken;
        
        Pair(int dest, int timeTaken){
            this.dest = dest;
            this.timeTaken = timeTaken;
        }
        
        public int compareTo(Pair o){
         return this.timeTaken-o.timeTaken;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Pair>>graph = new ArrayList<>();
        
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int t[] : times){
            graph.get(t[0]).add(new Pair(t[1],t[2]));
        }
        
        int distArr[] = new int[n+1];
        Arrays.fill(distArr,Integer.MAX_VALUE);
        
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        distArr[k] = 0;
        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            
            for(Pair nbrs : graph.get(rem.dest)){
                
                if(nbrs.timeTaken+rem.timeTaken<distArr[nbrs.dest]){
                    distArr[nbrs.dest] = nbrs.timeTaken+rem.timeTaken;
                    pq.add(new Pair(nbrs.dest,distArr[nbrs.dest]));
                }
            }
        }
        
        int maxDelay = -1;
      for(int i = 1; i<=n; i++){
          int ele = distArr[i];
          if(ele == Integer.MAX_VALUE)return -1;
            maxDelay = Math.max(maxDelay,ele);
      }
        
        return maxDelay;
    }
}