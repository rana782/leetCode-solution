// LeetCode: Custom Sort String (custom-sort-string)
// Submission ID: 1656285391
// Language: java
// Timestamp (UTC): 2025-06-07T06:23:54Z

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        
        StringBuilder output = new StringBuilder();
        
        for(int i = 0; i<order.length(); i++){
            char ch = order.charAt(i);
            
            if(map.containsKey(ch)){
               int steps = map.get(ch);
                while(steps-->0)output.append(ch);
                
                map.remove(ch);
            }
        }
        
        
        for(char ch : map.keySet()){
            int steps = map.get(ch);
            while(steps-->0){
                output.append(ch);
            }
        }
        
        System.out.println(output.toString());
        
        return output.toString();
    }
}