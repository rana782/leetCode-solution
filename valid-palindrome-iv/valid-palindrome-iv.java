// LeetCode: Valid Palindrome IV (valid-palindrome-iv)
// Submission ID: 1620008233
// Language: java
// Timestamp (UTC): 2025-04-28T07:32:45Z

class Solution {
    public boolean makePalindrome(String s) {
        int i = s.length()-1;

        int j = 0;
        int pairs = 0;

        while(j<=i){
            char chLast = s.charAt(i);
            char chFirst = s.charAt(j);

            if(chLast!=chFirst){
                pairs++;

                if(pairs>2)return false;
            }
            i--;
            j++;
        }

        return true;
    }
}