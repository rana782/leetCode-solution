// LeetCode: Factorial Trailing Zeroes (factorial-trailing-zeroes)
// Submission ID: 1332912092
// Language: java
// Timestamp (UTC): 2024-07-25T11:16:47Z

class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while(n>0){
            n = n/5;
            ans+=n;
        }
        return ans;
    }
}