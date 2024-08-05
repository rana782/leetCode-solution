// LeetCode: Is Subsequence (is-subsequence)
// Submission ID: 1345223970
// Language: java
// Timestamp (UTC): 2024-08-05T10:18:19Z

class Solution {
    public boolean isSubsequence(String s, String t) {
      if(s.length()>t.length()){
        return false;
      }
      int j = 0;
      int i = 0;
     while(i<s.length() &&j<t.length()){
 if(s.charAt(i) == t.charAt(j)){
            i++;
            j++;
        }
        else{
            j++;
        }
     }
       
      
 if(i == s.length()){
        return true;
      }
      return false;
     
    }
}
