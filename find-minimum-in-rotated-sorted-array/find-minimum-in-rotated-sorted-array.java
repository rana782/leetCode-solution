// LeetCode: Find Minimum in Rotated Sorted Array (find-minimum-in-rotated-sorted-array)
// Submission ID: 1670446081
// Language: java
// Timestamp (UTC): 2025-06-20T11:10:24Z

class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
         int low = 0;
         int high = nums.length-1;


         while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[low]<=nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
         }

         return ans;
    }
}