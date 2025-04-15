// LeetCode: Sum of Absolute Differences in a Sorted Array (sum-of-absolute-differences-in-a-sorted-array)
// Submission ID: 1607502817
// Language: java
// Timestamp (UTC): 2025-04-15T12:09:34Z

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;

        int left[] =  new int[n];
        left[0] = 0;

        for(int i =0; i<n-1; i++){
            left[i+1] = left[i]+nums[i];
        }

        int right[] = new int[n];
        right[n-1] = 0;

        for(int i = n-1; i>0; i--){
            right[i-1] = right[i]+nums[i];
        }

        int output[] = new int[n];

        for(int i = 0; i<n; i++){

            int leftSum = Math.abs((nums[i]*(i-0))-left[i]);
            int rightSum = Math.abs((nums[i]*(n-i-1))-right[i]);

            output[i] = leftSum+rightSum;
        }

        return output;
    }
}