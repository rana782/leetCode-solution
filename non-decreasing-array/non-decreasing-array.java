// LeetCode: Non-decreasing Array (non-decreasing-array)
// Submission ID: 1336402129
// Language: java
// Timestamp (UTC): 2024-07-28T16:07:33Z

class Solution {
    public boolean checkPossibility(int[] nums) {
        int pos = -1;

        for(int i =0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                if(pos!=-1){
                    return false;
                }
                else{
                    pos = i;
                }
            }
        }

        return pos == -1 || pos == 0 || pos == nums.length-2||nums[pos-1]<=nums[pos+1]||nums[pos]<=nums[pos+2];
    }
}