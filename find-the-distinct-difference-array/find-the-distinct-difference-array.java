// LeetCode: Find the Distinct Difference Array (find-the-distinct-difference-array)
// Submission ID: 1511255552
// Language: java
// Timestamp (UTC): 2025-01-17T07:12:12Z

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n= nums.length;
         int diffPrefix[] = new int[n];
         
         int diffSuffix[] = new int[n];
         HashSet<Integer> diffEle = new HashSet<>();
         
         diffPrefix[0] = 1;
         diffEle.add(nums[0]);
         for(int i= 1; i<n; i++) {
        	 diffEle.add(nums[i]);
        	 diffPrefix[i] = diffEle.size();
         }
         
         
         diffEle = new HashSet<>();
         diffSuffix[n-1] = 0;
         diffEle.add(nums[n-1]);
         
         for(int i = n-2; i>=0; i--) {
        	 diffSuffix[i] = diffEle.size();
        	 diffEle.add(nums[i]);
         }
         
         int output[] = new int[n];
         
         for(int i = 0; i<n; i++) {
        	 output[i] = diffPrefix[i]-diffSuffix[i];
         }
         
         return output;
         
    }
}