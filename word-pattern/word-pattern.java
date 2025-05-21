// LeetCode: Word Pattern (word-pattern)
// Submission ID: 1640250122
// Language: java
// Timestamp (UTC): 2025-05-21T11:41:46Z

import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) return false;
            } else {
                if (usedWords.contains(word)) return false; // word already assigned
                map.put(ch, word);
                usedWords.add(word);
            }
        }

        return true;
    }
}
