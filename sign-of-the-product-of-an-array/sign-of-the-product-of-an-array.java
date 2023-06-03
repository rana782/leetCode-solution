// LeetCode: Sign of the Product of an Array (sign-of-the-product-of-an-array)
// Submission ID: 962884540
// Language: java
// Timestamp (UTC): 2023-06-03T09:50:30Z

class Solution {
    
    public int arraySign(int[] nums) {
        int cnt =0;
    for(int i =0; i<nums.length; i++){
        if(nums[i]==0){
            return 0;
        }
        if(nums[i]<0){
            cnt++;
        }
    }
    if(cnt%2!=0){
        return -1;
    }
    else{
        return 1;
    }
    }
}