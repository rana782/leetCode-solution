// LeetCode: Subarrays with K Different Integers (subarrays-with-k-different-integers)
// Submission ID: 1599854175
// Language: java
// Timestamp (UTC): 2025-04-07T18:15:23Z

class Solution {
    public static int lessThanOrEqual(int nums[], int k){
        int ans = 0;
        int start = 0;

        HashMap<Integer,Integer>map = new HashMap<>();

        for(int end = 0; end<nums.length; end++){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);

            while(start<=end && map.size()>k){
                map.put(nums[start],map.get(nums[start])-1);

                if(map.get(nums[start]) == 0)map.remove(nums[start]);
                start++;
            }

            ans+=end-start+1;
        }

        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans1 = lessThanOrEqual(nums,k);
        int ans2 = lessThanOrEqual(nums,k-1);

        return ans1-ans2;
    }
}