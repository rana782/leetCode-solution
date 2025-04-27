// LeetCode: Minimum Swaps to Group All 1's Together II (minimum-swaps-to-group-all-1s-together-ii)
// Submission ID: 1619727059
// Language: java
// Timestamp (UTC): 2025-04-27T22:25:46Z

class Solution {
    public int minSwaps(int[] nums) {
        int len = nums.length;
        int data[] = new int[2*len];

        for(int i = 0; i<data.length; i++){
            data[i] = nums[i%len];
        }

        int oneCount = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1)oneCount++;
        }
        if(oneCount == 0 || oneCount == 1)return 0;
        
        int zeroCount = 0;
        for(int i = 0; i<oneCount; i++){
            if(nums[i] == 0)zeroCount++;
        }

        int output = zeroCount;
        int left = 0;

        for(int i = oneCount; i<data.length; i++){
                    if(data[i] == 0)zeroCount++;

                    if(data[left] == 0)zeroCount--;

                    left++;

                    output = Math.min(output, zeroCount);
        }

        return output;

    }
}