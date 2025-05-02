// LeetCode: Count Positions on Street With Required Brightness (count-positions-on-street-with-required-brightness)
// Submission ID: 1623598287
// Language: java
// Timestamp (UTC): 2025-05-02T12:37:57Z

class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int output[] = new int[n];

        for(int c[] : lights){
            int sIdx = Math.max(0,c[0]-c[1]);
            int eIdx= Math.min(n-1,c[0]+c[1]);

            output[sIdx]+=1;

            if(eIdx+1<n)output[eIdx+1]-=1;
        }

        int prefixSum = 0;
        for(int i = 0; i<n; i++){
            prefixSum+=output[i];
            output[i] = prefixSum;
        }

        int res = 0;

        for(int i = 0; i<n; i++){
            if(output[i]>=requirement[i])res++;
        }

        return res;
    }
}