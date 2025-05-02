// LeetCode: Range Addition (range-addition)
// Submission ID: 1623589123
// Language: java
// Timestamp (UTC): 2025-05-02T12:21:24Z

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int output[]= new int[length];

        for(int c[] : updates){
            int sIdx = c[0];
            int eIdx = c[1];
            int inc = c[2];

            output[sIdx]+=inc;

            if(eIdx+1<length)output[eIdx+1]-=inc;
        }

        int prefixSum = 0;

        for(int i = 0; i<length; i++){
            prefixSum+=output[i];

            output[i] = prefixSum;
        }

        return output;
    }
}