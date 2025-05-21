// LeetCode: Power of Three (power-of-three)
// Submission ID: 1640690856
// Language: java
// Timestamp (UTC): 2025-05-21T21:16:13Z

class Solution {
    public static boolean solution(int n){
        if(n == 1)return true;

        if(n%3 == 0)return solution(n/3);

        return false;
    }
    public boolean isPowerOfThree(int n) {
        if(n<=0)return false;

        return solution(n);
    }
}