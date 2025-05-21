// LeetCode: Sentence Similarity (sentence-similarity)
// Submission ID: 1640047443
// Language: java
// Timestamp (UTC): 2025-05-21T06:59:56Z

import java.util.*;

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        HashMap<String, Set<String>> map = new HashMap<>();

        for (List<String> pair : similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            map.computeIfAbsent(word1, k -> new HashSet<>()).add(word2);
            map.computeIfAbsent(word2, k -> new HashSet<>()).add(word1);
        }

        for (int i = 0; i < sentence1.length; i++) {
            String w1 = sentence1[i];
            String w2 = sentence2[i];
            if (w1.equals(w2)) continue;
            if (!map.containsKey(w1) || !map.get(w1).contains(w2)) {
                return false;
            }
        }

        return true;
    }
}
