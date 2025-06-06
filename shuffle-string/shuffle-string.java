// LeetCode: Shuffle String (shuffle-string)
// Submission ID: 1655710362
// Language: java
// Timestamp (UTC): 2025-06-06T13:41:08Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        Character ch;
        int idx;
        
        Pair(Character ch, int idx){
            this.ch = ch;
            this.idx = idx;
        }
        
        public int compareTo(Pair o){
            return this.idx-o.idx;
        }
        
        
    }
    public String restoreString(String s, int[] indices) {
        
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        
        for(int i = 0; i<indices.length; i++){
            char ch = s.charAt(i);
            int num = indices[i];
            
            pq.add(new Pair(ch,num));
        }
        
        StringBuilder output = new StringBuilder();
        
        while(pq.size()!=0){
            Pair rem = pq.poll();
            
            output.append(rem.ch);
        }
        
        System.out.println(output);
        return output.toString();
    }
}