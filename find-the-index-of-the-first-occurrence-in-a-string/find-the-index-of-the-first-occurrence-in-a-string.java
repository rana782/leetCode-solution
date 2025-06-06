// LeetCode: Find the Index of the First Occurrence in a String (find-the-index-of-the-first-occurrence-in-a-string)
// Submission ID: 1655687947
// Language: java
// Timestamp (UTC): 2025-06-06T13:10:02Z

class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle))return -1;
        
        int n = needle.length();
        
        int idx = 0;
        
        while(idx<haystack.length() && n<=haystack.length()){
            String substr = haystack.substring(idx,idx+n);
            if(substr.equals(needle))return idx;
            idx++;
        }
        
        
        return -1;
    }
}