// LeetCode: Reverse String (reverse-string)
// Submission ID: 1333081220
// Language: java
// Timestamp (UTC): 2024-07-25T14:23:23Z

class Solution {
    public void reverseString(char[] s) {
        
       int left = 0;
       int right = s.length-1;

       while(left<right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
       
       }
    }
}