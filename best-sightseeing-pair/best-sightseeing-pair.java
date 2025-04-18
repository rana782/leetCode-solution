// LeetCode: Best Sightseeing Pair (best-sightseeing-pair)
// Submission ID: 1610886133
// Language: java
// Timestamp (UTC): 2025-04-18T20:10:58Z

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        int maxArr[] = new int[n];

        int maxi = Integer.MIN_VALUE;

        for(int i = n-1; i>0; i--){
            maxi = Math.max(maxi,values[i]-i);
            maxArr[i] = maxi;
        }


        int output = Integer.MIN_VALUE;

        for(int i = 0; i<n-1; i++){
            int currVal = values[i]+i+maxArr[i+1];
            output = Math.max(output,currVal);
        }

        return output;
    }
}