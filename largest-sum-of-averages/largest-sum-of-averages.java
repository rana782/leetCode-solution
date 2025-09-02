// LeetCode: Largest Sum of Averages (largest-sum-of-averages)
// Submission ID: 1756663307
// Language: java
// Timestamp (UTC): 2025-09-02T05:52:40Z

class Solution {
    static int K;
    static double memo[][];
    public static double solution(int idx, int nums[], int currK) {
        if (currK == K) {
            // Base case: compute average of the rest of the array from idx to the end
            double sum = 0;
            int count = 0;
            for (int i = idx; i < nums.length; i++) {
                sum += nums[i];
                count++;
            }
            // Avoid division by zero if no elements left
            return count == 0 ? 0 : sum / count;
        }

        if (idx == nums.length) return 0;

        if(memo[idx][currK]!=-1)return memo[idx][currK];
        double output = 0;
        double currSum = 0;
        // Try ending the partition at every possible position
        for (int i = idx; i < nums.length; i++) {
            currSum += nums[i];
            double currAvg = currSum / (i - idx + 1);
            output = Math.max(output, currAvg + solution(i + 1, nums, currK + 1));
        }

        return memo[idx][currK] = output;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        K = k;
        memo = new double[nums.length][k+1];

        for(double d[] : memo){
            Arrays.fill(d,-1);
        }
        return solution(0, nums, 1);
    }
}
