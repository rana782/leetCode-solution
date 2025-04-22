// LeetCode: Largest Unique Number (largest-unique-number)
// Submission ID: 1614459707
// Language: java
// Timestamp (UTC): 2025-04-22T09:33:35Z

class Solution {
    public int largestUniqueNumber(int[] nums) {
        

      int arr[] = new int[2001];

      for(int ele : nums){
        arr[ele]++;
      }

      for(int i = arr.length-1; i>=0; i--){
        if(arr[i] == 1)return i;
      }

      return -1;
    }
}