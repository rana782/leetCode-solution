// LeetCode: Number of Equivalent Domino Pairs (number-of-equivalent-domino-pairs)
// Submission ID: 1666604441
// Language: java
// Timestamp (UTC): 2025-06-17T01:29:02Z

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        HashMap<String,Integer>map = new HashMap<>();
        int output = 0;
        
       for(int d[] : dominoes){
           
           int diff = Math.abs(d[0]-d[1]);
           
           int sum = d[0]+d[1];
           
           String code = diff+"_"+sum;
           
           if(map.containsKey(code))output+=map.get(code);
           
           map.put(code,map.getOrDefault(code,0)+1);
       }
        
        return output;
    }
}