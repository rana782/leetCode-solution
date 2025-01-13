// LeetCode: Sum of Digits of String After Convert (sum-of-digits-of-string-after-convert)
// Submission ID: 1507161250
// Language: java
// Timestamp (UTC): 2025-01-13T11:03:08Z

class Solution {
    public int getLucky(String s, int k) {
	        
		  
		  int value = 0;
		  
		  for(int i = 0; i<s.length(); i++) {
			  char ch = s.charAt(i);
			  value+=getSum(ch-'a'+1);
		  }
		  
		  while(k!=1) {
			  value = getSum(value);
			  k--;
		  }
		  
		  return value;
	    }

	private int getSum(int value) {
		int sum = 0;
		while(value!=0) {
			sum+=value%10;
			value = value/10;
		}
		
		return sum;
	}
}