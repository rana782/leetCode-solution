// LeetCode: Rearrange Array to Maximize Prefix Score (rearrange-array-to-maximize-prefix-score)
// Submission ID: 1665698159
// Language: java
// Timestamp (UTC): 2025-06-16T06:42:33Z

class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);

        long prefixSum =0;
        int count = 0;
       

        for(int i = nums.length-1; i>=0; i--){
             prefixSum+=nums[i];
             if(prefixSum>0)count++;
             else{
                break;
             }
        }

        return count;

    }
}