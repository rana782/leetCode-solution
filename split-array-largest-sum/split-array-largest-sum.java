// LeetCode: Split Array Largest Sum (split-array-largest-sum)
// Submission ID: 1672205744
// Language: java
// Timestamp (UTC): 2025-06-22T03:42:03Z

class Solution {
    public static boolean isPossible(int maxSum, int arr[], int k){
        int count = 1;
         int currSum = 0;

         for(int i = 0; i<arr.length; i++){
            if(currSum+arr[i]>maxSum){
                count++;
                currSum = arr[i];
            }
            else{
                currSum+=arr[i];
            }

            if(count>k)return false;
         }

         return true;
    }
    public int splitArray(int[] nums, int k) {
        
        if(k>nums.length)return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;


        for(int ele : nums){
            low = Math.max(low,ele);
            high+=ele;
        }

        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(isPossible(mid, nums, k)){
                    ans = mid;
                    high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;

    }
}