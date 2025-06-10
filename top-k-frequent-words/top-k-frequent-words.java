// LeetCode: Top K Frequent Words (top-k-frequent-words)
// Submission ID: 1659314841
// Language: java
// Timestamp (UTC): 2025-06-10T04:41:07Z

class Solution {
    
    public static class Pair implements Comparable<Pair>{
        String w;
        int freq;
        
        Pair(String w, int freq){
            this.w = w;
            this.freq = freq;
        }
        
      public int compareTo(Pair o){
    if(this.freq != o.freq) return o.freq - this.freq;  // High freq first
    return this.w.compareTo(o.w);                       // Lexical order
}

    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map = new HashMap<>();
        
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        List<Pair>output = new ArrayList<>();
        for(String str : map.keySet()){
            output.add(new Pair(str,map.get(str)));
        }
        
        Collections.sort(output);
        
        List<String>res = new ArrayList<>();
        
        for(int i = 0; i<k; i++){
            res.add(output.get(i).w);
        }
        
       
        
        return res;
    }
}