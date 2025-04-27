// LeetCode: Length of the Longest Alphabetical Continuous Substring (length-of-the-longest-alphabetical-continuous-substring)
// Submission ID: 1619344321
// Language: java
// Timestamp (UTC): 2025-04-27T13:15:27Z

class Solution {
    public int longestContinuousSubstring(String s) {
        int output = 1;
        int j = 0;
        for(int i = 1; i<s.length(); i++){

            while(i<s.length() && s.charAt(i-1)+1 == s.charAt(i)){
               int len = i-j+1;
               output = Math.max(output,len);
               i++;

            }

            j = i;
        }

        return output;
    }
}