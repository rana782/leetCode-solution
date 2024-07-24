// LeetCode: A Number After a Double Reversal (a-number-after-a-double-reversal)
// Submission ID: 1332023819
// Language: java
// Timestamp (UTC): 2024-07-24T16:13:41Z

class Solution {
    public static int reverse(int n){
        int ans = 0;

        while(n!=0){
            int rem = n%10;
            ans = ans*10+rem;
            n = n/10;
        }
        return ans;
    }
    public boolean isSameAfterReversals(int num) {
        int rev1 = reverse(num);
        int rev2 = reverse(rev1);
        return num==rev2;
    }
}