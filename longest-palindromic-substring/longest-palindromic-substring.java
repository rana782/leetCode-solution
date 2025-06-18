// LeetCode: Longest Palindromic Substring (longest-palindromic-substring)
// Submission ID: 1667780530
// Language: java
// Timestamp (UTC): 2025-06-18T03:24:15Z

class Solution {
    
    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))return false;
            
            i++;
            j--;
        }
        
        return true;
    }
    public String longestPalindrome(String s) {
        String output = "";
        
        for(int i = 0; i<s.length(); i++){
            for(int j = i+1; j<=s.length(); j++){
                
                String subStr = s.substring(i,j);
           
            if(isPalindrome(subStr) && subStr.length()>output.length()){
                output = subStr;
            }
        }
        }
        
        return output;
        
        
    }
}