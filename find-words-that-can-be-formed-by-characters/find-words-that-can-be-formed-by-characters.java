// LeetCode: Find Words That Can Be Formed by Characters (find-words-that-can-be-formed-by-characters)
// Submission ID: 1667112774
// Language: java
// Timestamp (UTC): 2025-06-17T11:56:38Z

class Solution {
    public static boolean canForm(String str,HashMap<Character,Integer>map){
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch) == 0)map.remove(ch);
            }
            
            else{
                return false;
            }
        }
        
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        
        
        HashMap<Character,Integer>map = new HashMap<>();
        
        for(int i = 0; i<chars.length(); i++){
            char ch = chars.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        
        int output = 0;
        
        for(String str : words){
            if(canForm(str,new HashMap<>(map)))output+=str.length();
        }
        
        return output;
    }
}