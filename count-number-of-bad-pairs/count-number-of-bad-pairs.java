// LeetCode: Count Number of Bad Pairs (count-number-of-bad-pairs)
// Submission ID: 1536691086
// Language: java
// Timestamp (UTC): 2025-02-09T07:00:23Z

class Solution {
    public long countBadPairs(int[] nums) {
        

      long badPair = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int diff = i-nums[i];

             int goodPair = map.getOrDefault(diff,0);
             badPair+=i-goodPair;

            map.put(diff,map.getOrDefault(diff,0)+1);
        }

     return badPair;
    }
}