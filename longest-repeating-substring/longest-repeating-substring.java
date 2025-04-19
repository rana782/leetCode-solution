// LeetCode: Longest Repeating Substring (longest-repeating-substring)
// Submission ID: 1611044936
// Language: java
// Timestamp (UTC): 2025-04-19T02:18:56Z

class Solution {
    public int longestRepeatingSubstring(String s) {
        HashSet<String>set = new HashSet<>();

        int output = Integer.MIN_VALUE;

        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){

                String str = s.substring(i, j+1);

                if(set.contains(str)){
                    int len = j-i+1;
                    output = Math.max(len, output);
                }
                set.add(str);
            }
        }

        return output == Integer.MIN_VALUE ? 0 : output;
    }
}