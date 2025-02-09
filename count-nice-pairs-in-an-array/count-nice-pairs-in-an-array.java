// LeetCode: Count Nice Pairs in an Array (count-nice-pairs-in-an-array)
// Submission ID: 1536706717
// Language: java
// Timestamp (UTC): 2025-02-09T07:16:15Z

class Solution {

    public static int rev(int x){
        int num = 0;

        while(x!=0){
            int rem = x%10;
            num = num*10+rem;
            x = x/10;
        }

        return num;
    }
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        int goodPairs = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int diff = nums[i]-rev(nums[i]);

            int currPair = map.getOrDefault(diff,0);

            goodPairs+=currPair;
            goodPairs = goodPairs%mod;
            map.put(diff,map.getOrDefault(diff,0)+1);
        }

        return goodPairs;
    }
}