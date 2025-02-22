// LeetCode: Partition to K Equal Sum Subsets (partition-to-k-equal-sum-subsets)
// Submission ID: 1551230664
// Language: java
// Timestamp (UTC): 2025-02-22T00:47:01Z

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        
        int targetSum = sum / k;
        Arrays.sort(nums);
        // add a reverse it helps!
        return backtrack(nums.length - 1, nums, new int[k], targetSum);
    }
    
    private boolean backtrack(int index, int[] nums, int[] sums, int targetSum) {
        if (index < 0) return true;
        
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[index] > targetSum) continue;
            
            sums[i] += nums[index];
            
            if (backtrack(index - 1, nums, sums, targetSum)) {
                return true;
            }
            
            sums[i] -= nums[index];
            
            if (sums[i] == 0) break;
        }
        
        return false;
    }
}