// LeetCode: Find Smallest Letter Greater Than Target (find-smallest-letter-greater-than-target)
// Submission ID: 1555830444
// Language: java
// Timestamp (UTC): 2025-02-26T07:44:26Z

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(int i = 0; i<letters.length; i++){
            char ch = letters[i];

            if(ch>target) return ch;
        }

        return letters[0];
    }
}