// LeetCode: Concatenation of Array (concatenation-of-array)
// Submission ID: 963003881
// Language: java
// Timestamp (UTC): 2023-06-03T13:59:36Z

class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
       for(int i =0; i<n; i++){
           ans[i] = nums[i];
           ans[i+n] = nums[i];
       }
       return ans;

    }
}