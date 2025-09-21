// LeetCode: Bitwise OR of Even Numbers in an Array (bitwise-or-of-even-numbers-in-an-array)
// Submission ID: 1777544403
// Language: java
// Timestamp (UTC): 2025-09-21T02-32-29Z

class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int output = 0;

        for(int ele : nums){
            if(ele%2 == 0){
                output|=ele;
            }
        }

        return output;
    }
}