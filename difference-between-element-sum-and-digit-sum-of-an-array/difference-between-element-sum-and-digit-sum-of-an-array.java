// LeetCode: Difference Between Element Sum and Digit Sum of an Array (difference-between-element-sum-and-digit-sum-of-an-array)
// Submission ID: 963130000
// Language: java
// Timestamp (UTC): 2023-06-03T17:54:23Z

class Solution {
    public int differenceOfSum(int[] nums) {
        int elesum = 0, digisum = 0;
        for(int i = 0; i<nums.length; i++){
            elesum+=nums[i];
            int rem = 0;
            while(nums[i]!=0){
                digisum+=(nums[i]%10);
                nums[i] = nums[i]/10;
            }
        }
        return Math.abs(elesum-digisum);
    }
}