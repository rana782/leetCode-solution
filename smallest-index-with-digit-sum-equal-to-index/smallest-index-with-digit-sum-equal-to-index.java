// LeetCode: Smallest Index With Digit Sum Equal to Index (smallest-index-with-digit-sum-equal-to-index)
// Submission ID: 1638144124
// Language: java
// Timestamp (UTC): 2025-05-19T10:22:29Z

class Solution {
    public static int getDigitSum(int n){
        int sum = 0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
        
    }
    public int smallestIndex(int[] nums) {
        
        for(int i = 0; i<nums.length; i++){
            int n = nums[i];
            int digitSum = getDigitSum(n);
            if(digitSum == i)return i;
        }
        
        return -1;
    }
}