// LeetCode: Palindrome Number (palindrome-number)
// Submission ID: 1333826942
// Language: java
// Timestamp (UTC): 2024-07-26T06:59:45Z

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int original = x;
int reverse = 0;
        while(x!=0){
            int rem = x%10;
            reverse = reverse*10+rem;
            x = x/10;
        }

       if(original == reverse){
        return true;
       }
       return false;
    }
}