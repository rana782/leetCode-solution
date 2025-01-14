// LeetCode: Separate Black and White Balls (separate-black-and-white-balls)
// Submission ID: 1508285887
// Language: java
// Timestamp (UTC): 2025-01-14T12:01:00Z

class Solution {
      public long minimumSteps(String s) {
        long minSwap = 0;
         long zeroCount = 0;
         
         for(int i = s.length()-1; i>=0; i--) {
        	 char ch = s.charAt(i);
        	 if(ch == '0') zeroCount++;
        	 else {
        		 minSwap+=zeroCount;
        	 }
         
        	
    }
         
         return minSwap;	
  }
}