// LeetCode: Move Zeroes (move-zeroes)
// Submission ID: 1658987123
// Language: java
// Timestamp (UTC): 2025-06-09T18:49:29Z

class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer>res = new ArrayList<>();
        for(int ele : nums){
            if(ele!=0)res.add(ele);
        }
        
        for(int i = 0; i<nums.length; i++){
            if(i<res.size()){
                nums[i] = res.get(i);
            }
            else{
                nums[i] = 0;
            }
        }
    }
}