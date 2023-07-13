// LeetCode: Remove All Adjacent Duplicates In String (remove-all-adjacent-duplicates-in-string)
// Submission ID: 993202934
// Language: java
// Timestamp (UTC): 2023-07-13T05:29:20Z

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0; i<s.length(); i++){
            if(st.empty()){
                st.push(s.charAt(i));
            }
            else if(st.peek() == s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
          StringBuilder ans= new StringBuilder();

        while(!st.isEmpty()){
            ans.append( st.pop());
        }


        // reverse it as stack is first in last out
        return ans.reverse().toString() ;
    }
}