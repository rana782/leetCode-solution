// LeetCode: Minimum Penalty for a Shop (minimum-penalty-for-a-shop)
// Submission ID: 1606873729
// Language: java
// Timestamp (UTC): 2025-04-14T18:19:40Z

class Solution {
   	 public int bestClosingTime(String customers) {
	        int n = customers.length();
	        
	        int left[] = new int[n+1];
	         int right[] = new int[n+1];
	         
	         
	         left[0] = 0;
	         
	         for(int i = 0; i<n; i++) {
	        	 char ch = customers.charAt(i);
	        	 
	        	 if(ch == 'N') {
	        		 left[i+1] = left[i]+1;
	        	 }
	        	 
	        	 else {
	        		 left[i+1] = left[i];
	        	 }
	         }
	         
	         right[n] = 0;
	         
	         for(int i = n-1; i>=0; i--) {
	        	 char ch = customers.charAt(i);
	        	 right[i] = ch == 'Y' ? right[i+1]+1 : right[i+1];
	         }
	         
	         int minP = Integer.MAX_VALUE;
	         int time = -1;
	         
	         for(int i = 0; i<=n; i++) {
	        	 int sum = left[i]+right[i];
	        	 
	        	 if(sum<minP) {
	        		 minP = sum;
	        		 time = i;
	        	 }
	         }
	         
	         return time;
	    }
}