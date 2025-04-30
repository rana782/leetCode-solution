// LeetCode: Find Numbers with Even Number of Digits (find-numbers-with-even-number-of-digits)
// Submission ID: 1622130452
// Language: java
// Timestamp (UTC): 2025-04-30T16:58:31Z

class Solution {
    public int findNumbers(int[] nums) {
        int output = 0;
        for(int ele : nums){
            String str = String.valueOf(ele);

            if(str.length()%2 == 0)output++;
        }

        return output;
    }
}