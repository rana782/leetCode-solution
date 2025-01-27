// LeetCode: Append Characters to String to Make Subsequence (append-characters-to-string-to-make-subsequence)
// Submission ID: 1522172019
// Language: java
// Timestamp (UTC): 2025-01-27T14:07:11Z

class Solution {
    public int appendCharacters(String s, String t) {
        int pointerAtS = 0;
         int pointerAtT = 0;

         while(pointerAtS<s.length() && pointerAtT<t.length()){

            if(s.charAt(pointerAtS) == t.charAt(pointerAtT)){
                pointerAtS++;
                pointerAtT++;
            }

            else{
                pointerAtS++;
            }
         }


         if(pointerAtT == t.length()) return 0;

         return t.length()-pointerAtT;
    }
}