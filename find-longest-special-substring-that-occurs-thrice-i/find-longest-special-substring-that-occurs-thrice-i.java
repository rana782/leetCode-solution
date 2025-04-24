// LeetCode: Find Longest Special Substring That Occurs Thrice I (find-longest-special-substring-that-occurs-thrice-i)
// Submission ID: 1616546835
// Language: java
// Timestamp (UTC): 2025-04-24T10:35:18Z

class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer>map = new HashMap<>();
        
        int output = -1;

     for(int i = 0; i<s.length(); i++){
            HashMap<Character,Integer>special = new HashMap<>();

        for(int j = i;j<s.length(); j++){
            char ch = s.charAt(j);
            special.put(ch,special.getOrDefault(ch,0)+1);
            if(special.size() == 1){
                String str = s.substring(i,j+1);
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
     }

        for(String str : map.keySet()){
            if(map.get(str)>=3){
                output = Math.max(output,str.length());
            }
        }

        return output;
    }
}