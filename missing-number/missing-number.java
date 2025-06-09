// LeetCode: Missing Number (missing-number)
// Submission ID: 1658942736
// Language: java
// Timestamp (UTC): 2025-06-09T18:06:09Z

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int total = n*(n+1)/2;
        
        int currSum = 0;
        
        for(int ele : nums){
            currSum+=ele;
        }
        
        return total-currSum;
        
    }
}