// LeetCode: Product of Array Except Self (product-of-array-except-self)
// Submission ID: 1657824040
// Language: java
// Timestamp (UTC): 2025-06-08T16:23:42Z

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int left[] = new int[n];
        
        int right[] = new int[n];
        
        
        left[0] = 1;
        right[n-1] = 1;
        
        for(int i = 1; i<nums.length; i++){
            left[i] = left[i-1]*nums[i-1];
        }
        
        for(int j = n-2; j>=0; j--){
            right[j] = right[j+1]*nums[j+1];
        }
        
        int output[] = new int[n];
        
        for(int i = 0; i<nums.length; i++){
            output[i] = left[i]*right[i];
        }
        
        return output;
    }
}