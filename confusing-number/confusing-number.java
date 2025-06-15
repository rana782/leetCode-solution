// LeetCode: Confusing Number (confusing-number)
// Submission ID: 1664310536
// Language: java
// Timestamp (UTC): 2025-06-15T00:10:29Z

class Solution {
    public boolean confusingNumber(int n) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        String original = Integer.toString(n);
        StringBuilder rotated = new StringBuilder();

        for (int i = original.length() - 1; i >= 0; i--) {
            char c = original.charAt(i);
            if (!map.containsKey(c)) return false;
            rotated.append(map.get(c));
        }

        return !original.equals(rotated.toString());
    }
}
