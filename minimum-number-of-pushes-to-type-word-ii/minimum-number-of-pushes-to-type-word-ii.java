// LeetCode: Minimum Number of Pushes to Type Word II (minimum-number-of-pushes-to-type-word-ii)
// Submission ID: 1538474802
// Language: java
// Timestamp (UTC): 2025-02-10T19:02:46Z

class Solution {
   	public int minimumPushes(String word) {

		
		Integer freq[] = new Integer[27];
		
		Arrays.fill(freq,Integer.MIN_VALUE);
		
		for(int i = 0; i<word.length(); i++) {
			char ch = word.charAt(i);
			
			if(freq[ch-'a'] == Integer.MIN_VALUE) {
				freq[ch-'a'] = 1;
			}
			
			else {
				freq[ch-'a']++;
			}
		}
		
		Arrays.sort(freq,Collections.reverseOrder());
		
		
		int output = 0;
		
		for(int i = 0; i<freq.length; i++) {
			
			if(freq[i] == Integer.MIN_VALUE) return output;
			
			else {
				if(i>=0 && i<=7) {
					int cost = freq[i]*1;
					output+=cost;
				}
				
				else if(i>=8 && i<=15) {
					int cost = freq[i]*2;
					output+=cost;
				}
				
				
				else if(i>=16 && i<=23) {
					int cost = freq[i]*3;
					output+=cost;
				}
				
				else {
					int cost = freq[i]*4;
					output+=cost;
				}
			}
		}
		
		return output;
	     
    }
}