// LeetCode: Sequential Digits (sequential-digits)
// Submission ID: 1608823769
// Language: java
// Timestamp (UTC): 2025-04-16T18:20:38Z

class Solution {
   	static int Low;
	static int High;
	static List<Integer>output;
	
		public static void solution(int num, int prevDigit) {
			if(num>High)return;
			
			if(num>=Low && num<=High)output.add(num);
			
			int curr = 0;
			if(prevDigit+1<=9) {
				curr = num*10+(prevDigit+1);
			}
			else {
				return;
			}
			
			solution(curr,prevDigit+1);
		}
		
	    public static List<Integer> sequentialDigits(int low, int high) {
	    	Low = low;
	    	High = high;
	        output = new ArrayList<>();
	        
	        
	        for(int i = 1; i<9; i++) {
	        	solution(i,i);
	        }
	        
	        Collections.sort(output);
            return output;
	        
	    }
}