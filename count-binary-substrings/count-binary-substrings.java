// LeetCode: Count Binary Substrings (count-binary-substrings)
// Submission ID: 1521873924
// Language: java
// Timestamp (UTC): 2025-01-27T07:30:38Z

class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int curr = 1;
         int prev =0;

         for(int i = 1; i<s.length(); i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                count+=Math.min(curr,prev);
                prev = curr;
                curr = 1;
            }
            else{
                curr++;
            }
    }

    return count+=Math.min(curr,prev);
    }
}