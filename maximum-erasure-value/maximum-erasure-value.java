// LeetCode: Maximum Erasure Value (maximum-erasure-value)
// Submission ID: 1616434388
// Language: java
// Timestamp (UTC): 2025-04-24T08:01:54Z

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int prefixSum[] = new int[n+1];
        prefixSum[0] = 0;

        for(int i = 1; i<=n; i++){
                prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }

        int output = 0;
        int j = 0;
        HashSet<Integer>set = new HashSet<>();

        for(int i = 0; i<n; i++){
           

            while(j<=i && set.contains(nums[i])){
              
                set.remove(nums[j]);
                j++;
            }
            set.add(nums[i]);
            int currSum = prefixSum[i+1]-prefixSum[j];
            output = Math.max(output,currSum);
        }

        return output;
    }
}