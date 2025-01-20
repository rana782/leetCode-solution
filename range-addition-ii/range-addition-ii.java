// LeetCode: Range Addition II (range-addition-ii)
// Submission ID: 1514676351
// Language: java
// Timestamp (UTC): 2025-01-20T14:50:40Z

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;

        for(int d[] : ops){

            minRow = Math.min(minRow,d[0]);
            minCol = Math.min(minCol,d[1]);
        }


        return minRow*minCol;
    }
}