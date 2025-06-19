// LeetCode: Height Checker (height-checker)
// Submission ID: 1668859272
// Language: java
// Timestamp (UTC): 2025-06-19T01:56:43Z

class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        
        
        int exp[] = heights.clone();
        
        Arrays.sort(exp);
        
        int count =0;
        
        for(int i = 0;i<heights.length; i++){
            if(exp[i]!=heights[i])count++;
        }
        
        return count;
    }
}