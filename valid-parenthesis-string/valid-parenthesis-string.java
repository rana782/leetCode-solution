// LeetCode: Valid Parenthesis String (valid-parenthesis-string)
// Submission ID: 1536959975
// Language: java
// Timestamp (UTC): 2025-02-09T12:31:57Z

class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
         int close = 0;

         for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '*'){
                open++;
            }

            else{
                if(open == 0) return false;
                else{
                    open--;
                }
            }
         }


         for(int i = s.length()-1; i>=0; i--){
            char ch = s.charAt(i);

            if(ch == ')' || ch == '*'){
                close++;
            }

            else{
                if(close == 0) return false;
                else{
                    close--;
                }
            }
         }

         return true;
    }
}