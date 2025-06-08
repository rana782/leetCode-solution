// LeetCode: Valid Palindrome II (valid-palindrome-ii)
// Submission ID: 1658058937
// Language: java
// Timestamp (UTC): 2025-06-08T22:05:15Z

class Solution {
    public static boolean palindrome(String str){
        int i = 0;
        int j = str.length()-1;
        
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++;
            j--;
        }
        
        return true;
    }
    public boolean validPalindrome(String s) {
        
        
        int i = 0;
        int j = s.length()-1;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                
                String s1 = s.substring(i,j);
                String s2 = s.substring(i+1,j+1);
                
                if(palindrome(s1) || palindrome(s2))return true;
                else{
                    return false;
                }
            }
            i++;
            j--;
        }
        
        return true;
    }
}