// LeetCode: Maximum Subarray Sum with One Deletion (maximum-subarray-sum-with-one-deletion)
// Submission ID: 1513441449
// Language: java
// Timestamp (UTC): 2025-01-19T10:27:09Z

class Solution {
     public int maximumSum(int[] arr) {
	        if(arr.length == 1) return arr[0];
	        
	        int prevNotDel = arr[0];
	         int prevDel = 0;
	         int overAllMax = arr[0];
	         
	         for(int i = 1; i<arr.length; i++) {
	        	prevDel = Math.max(prevNotDel,prevDel+arr[i]);
                prevNotDel = Math.max(arr[i],prevNotDel+arr[i]);

                overAllMax = Math.max(Math.max(prevNotDel,prevDel),overAllMax);
	         }
	         
	         return overAllMax;
	    }
}