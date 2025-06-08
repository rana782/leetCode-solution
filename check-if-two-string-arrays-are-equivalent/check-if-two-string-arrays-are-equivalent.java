// LeetCode: Check If Two String Arrays are Equivalent (check-if-two-string-arrays-are-equivalent)
// Submission ID: 1657980800
// Language: java
// Timestamp (UTC): 2025-06-08T19:30:24Z

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        
        for(String str : word1){
            str1.append(str);
        }
        
        for(String str : word2){
            str2.append(str);
        }
         System.out.println(str1);
        System.out.println(str2);
        
       return str1.toString().equals(str2.toString());
    }
}