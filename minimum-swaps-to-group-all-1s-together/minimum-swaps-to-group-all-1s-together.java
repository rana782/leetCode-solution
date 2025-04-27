// LeetCode: Minimum Swaps to Group All 1's Together (minimum-swaps-to-group-all-1s-together)
// Submission ID: 1619720403
// Language: java
// Timestamp (UTC): 2025-04-27T22:09:50Z

class Solution {
    public int minSwaps(int[] data) {
        int oneCount = 0;
        for(int i = 0; i<data.length; i++){
            if(data[i] == 1)oneCount++;
        }

        if(oneCount == 0 || oneCount == 1)return 0;

        int zeroCount = 0;
        for(int i = 0; i<oneCount; i++){
            if(data[i] == 0)zeroCount++;
        }

        
        int left = 0;

        int output = zeroCount;

        for(int i = oneCount; i<data.length; i++){
            if(data[i] == 0)zeroCount++;

            if(data[left] == 0) zeroCount--;

            left++;



               output = Math.min(output,zeroCount);
              
           
        }

        return output;
    }
}