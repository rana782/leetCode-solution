// LeetCode: Minimum Number of Steps to Make Two Strings Anagram (minimum-number-of-steps-to-make-two-strings-anagram)
// Submission ID: 1656054880
// Language: java
// Timestamp (UTC): 2025-06-06T21:33:15Z

class Solution {
    public int minSteps(String s, String t) {
        int freq[] = new int[26];
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            freq[ch-'a']++;
        }
        
        
        int output = 0;
        
        for(int i = 0; i<t.length(); i++){
        char ch = t.charAt(i);
            
            if(freq[ch-'a']>0)freq[ch-'a']--;
            else{
                output++;
            }
                
            
        }
        
        
        return output;
    }
}