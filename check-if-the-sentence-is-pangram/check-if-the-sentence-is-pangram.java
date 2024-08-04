// LeetCode: Check if the Sentence Is Pangram (check-if-the-sentence-is-pangram)
// Submission ID: 1344582605
// Language: java
// Timestamp (UTC): 2024-08-04T18:25:46Z

class Solution {
    public boolean checkIfPangram(String sentence) {
         HashMap<Character,Integer>map = new HashMap<>();
	        for(int i =0; i<sentence.length(); i++) {
	        	map.put(sentence.charAt(i), null);
	        }
	        String s ="abcdefghijklmnopqrstuvwxyz";
	        for(int i =0; i<s.length(); i++) {
	        	if(!map.containsKey(s.charAt(i))) {
	        		return false;
	        	}
	        }
	        return true;
    }
}