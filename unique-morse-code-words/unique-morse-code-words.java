// LeetCode: Unique Morse Code Words (unique-morse-code-words)
// Submission ID: 1756569139
// Language: java
// Timestamp (UTC): 2025-09-02T04:07:48Z

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String codes[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String>set = new HashSet<>();

        for(String str : words){
            StringBuilder currCode = new StringBuilder();
            for(char ch : str.toCharArray()){
                currCode.append(codes[ch-'a']);
            }

            set.add(currCode.toString());
        }

        return set.size();
    }
}