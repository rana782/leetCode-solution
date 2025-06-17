// LeetCode: Greatest Common Divisor of Strings (greatest-common-divisor-of-strings)
// Submission ID: 1666590782
// Language: java
// Timestamp (UTC): 2025-06-17T00:55:58Z

class Solution {
    
    public static boolean solution(String str1, String str2, int idx){
        if(idx>=str2.length())return true;
        
        
        String substr = str2.substring(idx,idx+str1.length());
        
        if(substr.equals(str1)){
            
            if(solution(str1,str2,idx+str1.length()))return true;
        }
        
        return false;
    }
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() == str2.length()){
            if(str1.equals(str2))return str1;
            return "";
        }
        
        
        String output = "";
        
        if(str1.length()<str2.length()){
            
            for(int i = 1; i<=str1.length(); i++){
                
                if(str2.length()%i == 0  && str1.length()%i == 0){
                    String substr = str1.substring(0,i);
                    
                    if(solution(substr,str2,0) && solution(substr,str1,0))output = substr;
                }
            }
            
            return output;
        }
        
        
            for(int i = 1; i<=str2.length(); i++){
                
                if(str1.length()%i == 0  && str2.length()%i == 0){
                    String substr = str2.substring(0,i);
                    
                    if(solution(substr,str1,0) && solution(substr,str2,0))output = substr;
                }
            }
        
        return output;
    }
}