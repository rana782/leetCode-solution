// LeetCode: Reverse Prefix of Word (reverse-prefix-of-word)
// Submission ID: 1601653790
// Language: java
// Timestamp (UTC): 2025-04-09T12:34:52Z

class Solution {
 	 public String reversePrefix(String word, char ch) {
	        int idx = -1;
	        
	        for(int i = 0; i<word.length(); i++) {
	        	char chr = word.charAt(i);
	        	
	        	if(ch == chr) {
	        		idx = i;
	        		break;
	        	}
	        }
	        
	        
	        if(idx == -1) return word;
	        
	        
	        String first = word.substring(0, idx+1);
	        String last = word.substring(idx+1);
	        
	        StringBuilder str = new StringBuilder(first);
	        
	        
	        return str.reverse().toString()+last;
	        
	        }
}