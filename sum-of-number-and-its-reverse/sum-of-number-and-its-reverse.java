// LeetCode: Sum of Number and Its Reverse (sum-of-number-and-its-reverse)
// Submission ID: 1509442396
// Language: java
// Timestamp (UTC): 2025-01-15T14:23:23Z

class Solution {
    public static int reverse(int number) {
    String rev = new StringBuilder(String.valueOf(number)).reverse().toString();
    return Integer.parseInt(rev);
}

public boolean sumOfNumberAndReverse(int num) {
    for (int i = 0; i <= num; i++) {
        int reversed = reverse(i);
        if (i + reversed == num) {
            return true;
        }
    }
    return false;
}

}