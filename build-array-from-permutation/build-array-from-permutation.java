// LeetCode: Build Array from Permutation (build-array-from-permutation)
// Submission ID: 962816037
// Language: java
// Timestamp (UTC): 2023-06-03T07:27:17Z

class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}