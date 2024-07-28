// LeetCode: Find Pivot Index (find-pivot-index)
// Submission ID: 1335983521
// Language: java
// Timestamp (UTC): 2024-07-28T07:33:26Z

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum[] = new int[nums.length];
        int left = 0;
        int rightSum[] = new int[nums.length];
        int right = 0;
        for(int i = 0; i<nums.length; i++){
            int j = nums.length-i-1;
            left+=nums[i];
            leftSum[i] = left;

            right+=nums[j];
            rightSum[j] = right;
        }

        for(int i = 0; i<nums.length; i++){
            if(leftSum[i]==rightSum[i]){
                return i;
            }
        }
        return -1;
    }
}