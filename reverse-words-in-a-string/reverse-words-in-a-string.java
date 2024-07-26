// LeetCode: Reverse Words in a String (reverse-words-in-a-string)
// Submission ID: 1333755134
// Language: java
// Timestamp (UTC): 2024-07-26T05:41:01Z

class Solution {
    public String reverseWords(String s) {
        String[] arr =s.split(" +");
       

        StringBuilder ans = new StringBuilder();

        for(int i = arr.length-1; i>=0; i--){
            ans.append(arr[i]);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}