// LeetCode: Pass the Pillow (pass-the-pillow)
// Submission ID: 1524365795
// Language: java
// Timestamp (UTC): 2025-01-29T13:45:11Z

class Solution {
    public int passThePillow(int n, int time) {

        if(time<n) return time+1;
        int divide_num = n-1;

        int rem = time%divide_num;
        int dir = time/divide_num;

        if(dir%2==0) return 1+rem;

        return n-rem;

        
    }
}