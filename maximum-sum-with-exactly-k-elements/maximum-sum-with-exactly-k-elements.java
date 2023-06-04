// LeetCode: Maximum Sum With Exactly K Elements  (maximum-sum-with-exactly-k-elements)
// Submission ID: 963599074
// Language: java
// Timestamp (UTC): 2023-06-04T10:02:55Z

class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i<k; i++){
             sum+=nums[nums.length-1];
             nums[nums.length-1] = ++nums[nums.length-1];
        }
        return sum;
    }
}