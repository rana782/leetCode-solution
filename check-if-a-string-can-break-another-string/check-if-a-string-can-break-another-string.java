// LeetCode: Check If a String Can Break Another String (check-if-a-string-can-break-another-string)
// Submission ID: 1556403165
// Language: java
// Timestamp (UTC): 2025-02-26T18:43:52Z

class Solution {

    public static boolean check(char str1[], char str2[]){
        for(int i = 0; i<str1.length; i++){
            if(str1[i]<str2[i]) return false;
        }

        return true;
    }
    public boolean checkIfCanBreak(String s1, String s2) {
         char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

  return check(a,b) || check(b,a);
  
    }
}