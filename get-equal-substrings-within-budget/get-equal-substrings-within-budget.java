// LeetCode: Get Equal Substrings Within Budget (get-equal-substrings-within-budget)
// Submission ID: 1599888357
// Language: java
// Timestamp (UTC): 2025-04-07T18:46:33Z

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int currCost = 0;
         int result = 0;

         int start = 0;

         int len = s.length();

         for(int i = 0; i<len; i++){
            int chS = s.charAt(i)-'0';
            int chT = t.charAt(i)-'0';

            int cost = Math.abs(chS-chT);

            currCost+=cost;

            while(start<=i && currCost>maxCost){
             chS = s.charAt(start)-'0';
            chT = t.charAt(start)-'0';

            cost = Math.abs(chS-chT);

            currCost-=cost;
            start++;
            }

            result = Math.max(result,i-start+1);
         }

         return result;
    }
}