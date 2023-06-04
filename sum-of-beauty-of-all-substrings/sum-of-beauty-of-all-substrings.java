// LeetCode: Sum of Beauty of All Substrings (sum-of-beauty-of-all-substrings)
// Submission ID: 1556446745
// Language: java
// Timestamp (UTC): 2025-02-26T19:35:38Z

class Solution {
  public static int beautySum(String s) {
	        if(s.length() == 1) return 0;

	        int output = 0;

	        for(int i = 0; i<s.length(); i++) {
	        	int freq[] = new int[26];
	        	for(int j = i; j<s.length(); j++) {
	        		freq[s.charAt(j)-'a']++;
	        		
	        		output+=getBeauty(freq);
	        	}
	        }
	        
	        return output;
	    }

	private static int getBeauty(int freq[]) {
		// TODO Auto-generated method stub
		
	
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for( int i : freq) {
			if(i!=0) {
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
		}
		
		
		return max-min;
		
		
		
	}

}