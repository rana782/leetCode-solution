// LeetCode: Valid Triangle Number (valid-triangle-number)
// Submission ID: 1517994931
// Language: java
// Timestamp (UTC): 2025-01-23T13:47:38Z

class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length == 1 || nums.length == 2) return 0;
        Arrays.sort(nums);

        int count = 0;

        for(int i = nums.length-1; i>=2; i--){
            int left = 0;
            int right = i-1;

            while(left<right){

                if(nums[left]+nums[right]>nums[i]){
                    count+=right-left;
                    right--;
                }
                else{
                    left++;
                }
            }
        }

        return count;
    }
}