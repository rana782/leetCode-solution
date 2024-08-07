// LeetCode: Largest Odd Number in String (largest-odd-number-in-string)
// Submission ID: 1347944833
// Language: java
// Timestamp (UTC): 2024-08-07T16:23:20Z

class Solution {
    public String largestOddNumber(String num) {
        String charToString = String.valueOf(num.charAt(num.length() - 1));
        int stringToInt = Integer.parseInt(charToString);
        if (stringToInt % 2 != 0) {
            return num;
        } 
        String ans = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            String string_temp = String.valueOf(num.charAt(i));
            int int_temp = Integer.parseInt(string_temp);
            if (int_temp % 2 != 0) {
                ans = num.substring(0, i+1);
                return ans;
            } 
        }
        return ans;
    }
}