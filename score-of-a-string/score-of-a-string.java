// LeetCode: Score of a String (score-of-a-string)
// Submission ID: 1522156332
// Language: java
// Timestamp (UTC): 2025-01-27T13:50:52Z

class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for(int i = 1; i<s.length(); i++){
            int score1 = s.charAt(i)-'0';
            int score2 = s.charAt(i-1)-'0';

            score+=Math.abs(score1-score2);
        }

        return score;
    }
}