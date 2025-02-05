// LeetCode: Check if One String Swap Can Make Strings Equal (check-if-one-string-swap-can-make-strings-equal)
// Submission ID: 1532083136
// Language: java
// Timestamp (UTC): 2025-02-05T08:27:32Z

class Solution {
    public static boolean isAnagram(String s1, String s2){

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }


        for(int i = 0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }

                else{
                    map.put(ch,map.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }

        return map.size() == 0 ? true : false;
    }
    public boolean areAlmostEqual(String s1, String s2) {
        if(isAnagram(s1,s2)){
             int count = 0;

             for(int i =0; i<s1.length(); i++){
                if(s1.charAt(i)!=s2.charAt(i))count++;

                if(count>2) return false;
             }


             if(count == 2 || count == 0) return true;
        }

        return false;
    }
}