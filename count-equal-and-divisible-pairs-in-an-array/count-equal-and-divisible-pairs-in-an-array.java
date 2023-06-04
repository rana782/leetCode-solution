// LeetCode: Count Equal and Divisible Pairs in an Array (count-equal-and-divisible-pairs-in-an-array)
// Submission ID: 963608065
// Language: java
// Timestamp (UTC): 2023-06-04T10:21:16Z

class Solution {
    public int countPairs(int[] nums, int k) {
        int cnt = 0;
        for(int i =0; i<nums.length-1; i++){
            for(int j =i+1; j<nums.length; j++){
                if(nums[i]==nums[j] && (i*j)%k==0){
                    cnt++;

                }
            }
        }
      
        return cnt;
    }
}