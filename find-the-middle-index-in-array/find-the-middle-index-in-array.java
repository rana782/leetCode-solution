// LeetCode: Find the Middle Index in Array (find-the-middle-index-in-array)
// Submission ID: 1603585478
// Language: java
// Timestamp (UTC): 2025-04-11T11:17:26Z

class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;

        int leftSum[] = new int[n+1];
        int rightSum[] = new int[n+1];

        leftSum[0] = 0;

        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            leftSum[i+1] = sum;
        }

        sum = 0;

        rightSum[n] = 0;

        for(int i = n-1; i>=0; i--){
            sum+=nums[i];
            rightSum[i] = sum;
        }


        for(int i = 0; i<nums.length; i++){
            if(leftSum[i] == rightSum[i+1]) return i;
        }

        return -1;
    }
}