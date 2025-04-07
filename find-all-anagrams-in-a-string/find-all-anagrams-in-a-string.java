// LeetCode: Find All Anagrams in a String (find-all-anagrams-in-a-string)
// Submission ID: 1599507387
// Language: java
// Timestamp (UTC): 2025-04-07T12:12:24Z

class Solution {
    public static boolean isEqual(HashMap<Character,Integer> map1, HashMap<Character,Integer> map2) {
        if (map1.size() != map2.size()) return false;
        
        for (char ch : map1.keySet()) {
            if (!map2.containsKey(ch) || !map2.get(ch).equals(map1.get(ch))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        
        if (s.length() < p.length()) return output;

        // Frequency map for p
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // Frequency map for the first window in s
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // Check first window
        if (isEqual(map1, map2)) output.add(0);

        int start = 0;

        // Slide window
        for (int end = p.length(); end < s.length(); end++) {
            // Add new character
            char newChar = s.charAt(end);
            map2.put(newChar, map2.getOrDefault(newChar, 0) + 1);

            // Remove old character
            char oldChar = s.charAt(start++);
            if (map2.get(oldChar) == 1) {
                map2.remove(oldChar);
            } else {
                map2.put(oldChar, map2.get(oldChar) - 1);
            }

            // Compare maps
            if (isEqual(map1, map2)) output.add(start);
        }

        return output;
    }
}