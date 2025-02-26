// LeetCode: Largest Number At Least Twice of Others (largest-number-at-least-twice-of-others)
// Submission ID: 1556099601
// Language: java
// Timestamp (UTC): 2025-02-26T13:32:36Z

class Solution {

    public static boolean isTwice(int nums[], int largest, int idx){

        for(int i = 0; i<nums.length; i++){
            if( i!=idx && nums[i]*2>largest) return false;
        }

        return true;
    }
    public int dominantIndex(int[] nums) {
        int largest = -1;
        int idx = -1;

        for(int i = 0; i<nums.length; i++){
            if(nums[i]>largest){
                largest = nums[i];
                idx = i;
            }
        }

        if(isTwice(nums,largest, idx)) return idx;

        return -1;


    }
}