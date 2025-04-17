// LeetCode: Find the Student that Will Replace the Chalk (find-the-student-that-will-replace-the-chalk)
// Submission ID: 1609503239
// Language: java
// Timestamp (UTC): 2025-04-17T12:09:55Z

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long prefixSum = 0;

        for(int ele : chalk){
            prefixSum+=ele;
        }

        long rem = k%prefixSum;

        int idx = 0;

        while(idx<chalk.length){
            if(rem-chalk[idx]<0)return idx;

            rem-=chalk[idx];
            idx++;
        }

        return 0;
    }
}