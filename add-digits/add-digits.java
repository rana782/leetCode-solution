// LeetCode: Add Digits (add-digits)
// Submission ID: 1332853439
// Language: java
// Timestamp (UTC): 2024-07-25T10:09:04Z

class Solution {
    public static int add(int n){
        int ans = 0;
        while(n!=0){
            int rem = n%10;
            ans+=rem;
            n=n/10;

        }
        return ans;
    }
    
    public int addDigits(int num) {
        if(num<=9){
            return num;
        }

        int finale = 0;

finale = add(num);
        while(finale>9){
            finale = add(finale);
        }
        return finale;
    }
}