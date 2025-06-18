// LeetCode: K Closest Points to Origin (k-closest-points-to-origin)
// Submission ID: 1667775379
// Language: java
// Timestamp (UTC): 2025-06-18T03:16:04Z

class Solution {
    public class Pair implements Comparable<Pair>{
        int row,col;
        double dist;
        
        Pair(int row,int col,double dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
        
        public int compareTo(Pair o){
            return Double.compare(o.dist,this.dist);
        }
    }
    
    public static double calcDist(int x, int y){
        
        int dist = x*x+y*y;
        
        return Math.sqrt(dist);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        
        for(int d[] : points){
            
            double dist = calcDist(d[0],d[1]);
            
            if(pq.size()<k)pq.add(new Pair(d[0],d[1],dist));
            else if(pq.peek().dist>dist){
                pq.poll();
                pq.add(new Pair(d[0],d[1],dist));
            }
        }
        
        
        int output[][] = new int[k][2];
        
        int idx = 0;
        
        while(pq.size()!=0){
            Pair p = pq.poll();
            
            output[idx][0] = p.row;
            output[idx][1] = p.col;
            idx++;
        }
        
        return output;
        
        
    }
}