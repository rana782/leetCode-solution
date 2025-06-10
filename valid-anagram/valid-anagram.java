// LeetCode: Valid Anagram (valid-anagram)
// Submission ID: 1659382906
// Language: java
// Timestamp (UTC): 2025-06-10T05:50:50Z

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            
            if(!map.containsKey(ch))return false;
            else{
                map.put(ch,map.get(ch)-1);
                
                if(map.get(ch) == 0)map.remove(ch);
            }
        }
        
        return map.size() == 0;
    }
}