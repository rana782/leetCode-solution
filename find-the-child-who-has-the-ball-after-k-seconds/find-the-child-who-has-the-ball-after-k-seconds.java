// LeetCode: Find the Child Who Has the Ball After K Seconds (find-the-child-who-has-the-ball-after-k-seconds)
// Submission ID: 1524378480
// Language: java
// Timestamp (UTC): 2025-01-29T13:58:50Z

class Solution {
    public int numberOfChild(int n, int k) {
        if(k<n) return k;


        int divide_num = n-1;

        int rem = k%divide_num;
        int quo = k/divide_num;

        if(quo%2 == 0) return rem;

        return n-rem-1;
    }
}