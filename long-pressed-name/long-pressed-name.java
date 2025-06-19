// LeetCode: Long Pressed Name (long-pressed-name)
// Submission ID: 1668877706
// Language: java
// Timestamp (UTC): 2025-06-19T02:35:34Z

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        
        return i == name.length();
    }
}
