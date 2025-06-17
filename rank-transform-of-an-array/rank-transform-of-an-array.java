// LeetCode: Rank Transform of an Array (rank-transform-of-an-array)
// Submission ID: 1666682501
// Language: java
// Timestamp (UTC): 2025-06-17T03:54:18Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int num,idx;
        
        Pair(int num,int idx){
            this.num = num;
            this.idx = idx;
        }
        
        public int compareTo(Pair o){
            return this.num-o.num;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        
        
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        
        int n = arr.length;
        
        for(int i = 0; i<n; i++){
            pq.add(new Pair(arr[i],i));
        }
        
        int output[] = new int[n];
        
        int rank = 1;
        
        int prevNum = Integer.MIN_VALUE;
        int prevRank = -1;
        
        while(!pq.isEmpty()){
            Pair rem = pq.poll();
            
            if(rem.num == prevNum)output[rem.idx] = prevRank;
            else{
                output[rem.idx] = rank;
                 prevNum = rem.num;
                prevRank = rank;
                rank++;
            }
            
            
            
          
        }
        
        return output;
    }
}