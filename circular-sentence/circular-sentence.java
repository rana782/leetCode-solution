// LeetCode: Circular Sentence (circular-sentence)
// Submission ID: 1508673345
// Language: java
// Timestamp (UTC): 2025-01-14T18:53:00Z

class Solution {
    public boolean isCircularSentence(String s) {
        int n = s.length();

        if(s.charAt(0)!=s.charAt(n-1))return false;

        for(int i=1;i<n-1;i++){
            if(s.charAt(i)==' '){
                if(s.charAt(i-1)!=s.charAt(i+1))return false;
            }
        }
        
        return true;
    }
}