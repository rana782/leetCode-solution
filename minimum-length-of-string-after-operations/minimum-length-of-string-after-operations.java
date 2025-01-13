// LeetCode: Minimum Length of String After Operations (minimum-length-of-string-after-operations)
// Submission ID: 1507066328
// Language: java
// Timestamp (UTC): 2025-01-13T08:48:34Z

class Solution {
    public int minimumLength(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
	        for(int i = 0; i<s.length(); i++) {
	        	char ch = s.charAt(i);
	        	map.put(ch,map.getOrDefault(ch,0)+1);
	        }
	        
	        int outputLength = 0;
	        
	        for(int i :map.values()) {
	        	if(i%2 == 0) outputLength+=2;
                else outputLength+=1;
	        }
	        
	        return outputLength;
	    }

	
}