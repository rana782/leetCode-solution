// LeetCode: Valid Palindrome (valid-palindrome)
// Submission ID: 1658054785
// Language: java
// Timestamp (UTC): 2025-06-08T21:55:01Z

class Solution {
    public static String convert(String s){
        StringBuilder str = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)){
                if(Character.isUpperCase(ch))str.append(Character.toLowerCase(ch));
                else{
                    str.append(ch);
                }
            }
        }
        
        return str.toString();
    }
    
    public static boolean palindrome(String str){
        
        int i = 0;
         int j = str.length()-1;
        
        while(i<j){
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(j);
            
            if(ch1!=ch2)return false;
            i++;
            j--;
        }
        
        return true;
    }
    public boolean isPalindrome(String s) {
        String str = convert(s);
        System.out.println(str);
        
        
        return palindrome(str);
    }
}