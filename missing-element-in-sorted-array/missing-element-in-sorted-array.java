// LeetCode: Missing Element in Sorted Array (missing-element-in-sorted-array)
// Submission ID: 1611037604
// Language: java
// Timestamp (UTC): 2025-04-19T01:59:46Z

class Solution {
    public int missingElement(int[] nums, int k) {
        
        for(int i = 0; i<nums.length-1; i++){
            int diff = nums[i+1]-nums[i]-1;

            if(diff<k)k-=diff;
           else{
            return nums[i]+k;
           }
        }

        if(k!=0)return nums[nums.length-1]+k;

        return -1;
    }
}