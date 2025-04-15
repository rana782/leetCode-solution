// LeetCode: Reduction Operations to Make the Array Elements Equal (reduction-operations-to-make-the-array-elements-equal)
// Submission ID: 1607355516
// Language: java
// Timestamp (UTC): 2025-04-15T08:20:17Z

class Solution {
public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ops = 0;
        int n = nums.length;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                ops+=n-i;

            }
            
        }

        return ops;
    }
}