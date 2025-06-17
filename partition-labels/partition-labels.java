// LeetCode: Partition Labels (partition-labels)
// Submission ID: 1666701889
// Language: java
// Timestamp (UTC): 2025-06-17T04:20:10Z

class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer>map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }
        
        List<Integer>output = new ArrayList<>();
        
        int i = 0;
        
        while(i<s.length()){
          char ch = s.charAt(i);
            
            int lastOccured = map.get(ch);
            
            for(int j = i+1; j<lastOccured; j++){
                ch = s.charAt(j);
                
                lastOccured = Math.max(lastOccured,map.get(ch));
            }
            
            int length = lastOccured-i+1;
            output.add(length);
            i = lastOccured+1;
        }
        
        return output;
    }
}