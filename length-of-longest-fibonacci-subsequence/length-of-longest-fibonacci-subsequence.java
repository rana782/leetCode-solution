// LeetCode: Length of Longest Fibonacci Subsequence (length-of-longest-fibonacci-subsequence)
// Submission ID: 1556974559
// Language: java
// Timestamp (UTC): 2025-02-27T09:06:20Z

class Solution {
   	 public int lenLongestFibSubseq(int[] arr) {
	        int n = arr.length;
	        
	        HashMap<Integer,Integer> map = new HashMap<>();
	        
	        for(int i = 0; i<n; i++) {
	        	map.put(arr[i], i);
	        }
	        
	        int dp[][] = new int[n][n];
	        
	        for(int d[] : dp) {
	        	Arrays.fill(d,2);
	        }
	        int overAllMax = 2;
	        
	        for(int i = 0; i<n; i++) {
	        	for(int j = i+1; j<n; j++) {
	        		int k = arr[i]+arr[j];
                    if(k>arr[n-1]) break;
	        		
	        		if(map.containsKey(k)) {
	        		
	        			int nJ = map.get(k);
	        			
	        			dp[j][nJ] = dp[i][j]+1;
	        			overAllMax = Math.max(overAllMax, dp[j][nJ]);
	        		}
	        	}
	        }
	        
	        return overAllMax == 2 ? 0 : overAllMax;
	    }
}