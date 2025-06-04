// LeetCode: Maximum Nesting Depth of the Parentheses (maximum-nesting-depth-of-the-parentheses)
// Submission ID: 1654123529
// Language: java
// Timestamp (UTC): 2025-06-04T20:23:04Z

class Solution {
    public int maxDepth(String s) {
        
        int output = Integer.MIN_VALUE;
        
        int count = 0;
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                count++;
                output = Math.max(output,count);
            }
            else if(ch == ')')count--;
        }
        
        return output == Integer.MIN_VALUE ? 0 : output;
    }
}