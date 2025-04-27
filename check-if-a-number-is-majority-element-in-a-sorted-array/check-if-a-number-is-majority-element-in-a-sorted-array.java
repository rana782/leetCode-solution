// LeetCode: Check If a Number Is Majority Element in a Sorted Array (check-if-a-number-is-majority-element-in-a-sorted-array)
// Submission ID: 1619713177
// Language: java
// Timestamp (UTC): 2025-04-27T21:53:08Z

class Solution {
    public static boolean contains(int target, int nums[]){
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target)return true;
        }
        return false;
    }
    public boolean isMajorityElement(int[] nums, int target) {
        if(!contains(target,nums))return false;
        int leftMost = -1;
        int rightMost = -1;

        int low = 0;
         int high = nums.length-1;

         while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target){
                leftMost = mid;
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
         }

         low = 0;
         high = nums.length-1;

         while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid] == target){
                rightMost =  mid;
                low = mid+1;
            }

            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
         }

         int len = rightMost-leftMost+1;

         return len>nums.length/2;
    }
}