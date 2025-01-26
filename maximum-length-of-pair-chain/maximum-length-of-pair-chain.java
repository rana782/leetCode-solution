// LeetCode: Maximum Length of Pair Chain (maximum-length-of-pair-chain)
// Submission ID: 1520844065
// Language: java
// Timestamp (UTC): 2025-01-26T07:06:29Z

class Solution {
      public int findLongestChain(int[][] pairs) {
	        Arrays.sort(pairs,(a,b)->Integer.compare(a[1], b[1]));
	        
	        int overAllMax = 0;
	        int dp[] = new int[pairs.length];
	        
	        for(int i = 0; i<pairs.length; i++) {
	        	int max = 0;
	        	
	        	for(int j = 0; j<i; j++) {
	        		if(pairs[j][1]<pairs[i][0]) {
	        			max = Math.max(max, dp[j]);
	        		}
	        	}
	        	
	        	dp[i] = max+1;
	        	overAllMax = Math.max(overAllMax, dp[i]);
	        }
	        
	        
	        return overAllMax;
	    }
}