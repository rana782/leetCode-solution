// LeetCode: Clear Digits (clear-digits)
// Submission ID: 1538157068
// Language: java
// Timestamp (UTC): 2025-02-10T14:17:21Z

class Solution {
public String clearDigits(String s) {
    StringBuilder output = new StringBuilder();
    boolean[] visited = new boolean[s.length()];

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (Character.isDigit(ch)) {
            int idx = findNearestNon_digit(s, visited, i - 1);
            if (idx != -1) {
                visited[idx] = true;  // Mark the closest non-digit for removal
            }
            visited[i] = true;  // Mark the digit for removal
        }
    }

    for (int i = 0; i < s.length(); i++) {
        if (!visited[i]) {
            output.append(s.charAt(i));
        }
    }
    
    return output.toString();
}

private int findNearestNon_digit(String s, boolean[] visited, int i) {
    while (i >= 0) {
        if (Character.isLetter(s.charAt(i)) && !visited[i]) {
            return i;
        }
        i--;
    }
    return -1;  // No valid character found
}

}