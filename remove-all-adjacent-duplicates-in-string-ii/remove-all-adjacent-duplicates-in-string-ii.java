// LeetCode: Remove All Adjacent Duplicates in String II (remove-all-adjacent-duplicates-in-string-ii)
// Submission ID: 1735990844
// Language: java
// Timestamp (UTC): 2025-08-15T10:48:23Z

class Solution {
    public static class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair>st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek().ch == ch){
                st.push(new Pair(ch,st.peek().freq+1));

                int tempK = k;
                if(st.peek().freq == k){
                    while(tempK!=0){
                        st.pop();
                        tempK--;
                    }
                }
            }
            else{
                st.push(new Pair(ch,1));
            }
        }

        StringBuilder output = new StringBuilder();

        while(!st.isEmpty()){
            output.append(st.pop().ch);
        }

        return output.reverse().toString();
    }
}