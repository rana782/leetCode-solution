// LeetCode: Shortest Way to Form String (shortest-way-to-form-string)
// Submission ID: 1664307016
// Language: java
// Timestamp (UTC): 2025-06-14T23:59:50Z

class Solution {
    public int shortestWay(String source, String target) {
        Set<Character> set = new HashSet<>();
        for (char ch : source.toCharArray()) set.add(ch);

        for (char ch : target.toCharArray()) {
            if (!set.contains(ch)) return -1;  // impossible to form target
        }

        int i = 0, j = 0, res = 0;
        while (j < target.length()) {
            int prevJ = j;
            i = 0;
            while (i < source.length() && j < target.length()) {
                if (source.charAt(i) == target.charAt(j)) j++;
                i++;
            }
            res++;
            if (j == prevJ) return -1; // no progress made
        }

        return res;
    }
}
