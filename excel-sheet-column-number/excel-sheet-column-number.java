// LeetCode: Excel Sheet Column Number (excel-sheet-column-number)
// Submission ID: 1659395713
// Language: java
// Timestamp (UTC): 2025-06-10T06:03:12Z

class Solution {
    public int titleToNumber(String columnTitle) {
        StringBuilder str = new StringBuilder(columnTitle);
        str.reverse();
        System.out.println(str);
        
        
        
       int output = 0;
        
        for(int i = 0; i<str.length(); i++){
            int code  = str.charAt(i)-'A'+1;
            
            output+=Math.pow(26,i)*code;
        }
        
        return output;
    }
}