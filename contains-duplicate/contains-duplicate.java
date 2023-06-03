// LeetCode: Contains Duplicate (contains-duplicate)
// Submission ID: 962870865
// Language: java
// Timestamp (UTC): 2023-06-03T09:22:25Z

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
       for(int i =0; i<nums.length-1; i++){
           if(nums[i]==nums[i+1]){
               return true;
           }
       } 
       return false;
    }
}