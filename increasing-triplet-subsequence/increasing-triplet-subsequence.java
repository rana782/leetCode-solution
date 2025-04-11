// LeetCode: Increasing Triplet Subsequence (increasing-triplet-subsequence)
// Submission ID: 1603616196
// Language: java
// Timestamp (UTC): 2025-04-11T12:10:02Z


 class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;         
            } else if (num <= second) {
                second = num;     
            } else {
                return true;        
            }
        }

        return false;
    }
}

