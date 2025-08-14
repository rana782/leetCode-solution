// LeetCode: Two Sum (two-sum)
// Submission ID: 1735334279
// Language: java
// Timestamp (UTC): 2025-08-14T19:23:28Z

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int output[] = new int[2];
        HashMap<Integer,Integer>map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i]) && i!=map.get(target-nums[i])){
                output[0] = i;
                output[1] = map.get(target-nums[i]);
                return output;
            }
        }

        return output;
    }
}