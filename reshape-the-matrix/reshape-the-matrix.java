// LeetCode: Reshape the Matrix (reshape-the-matrix)
// Submission ID: 1513595270
// Language: java
// Timestamp (UTC): 2025-01-19T14:00:29Z

class Solution {
    	  public int[][] matrixReshape(int[][] mat, int r, int c) {
		  
		  if(r*c != mat.length*mat[0].length) return mat;
		  
		  
	         int ans[][]  = new int[r][c];
	         HashMap<Integer,Integer> map = new HashMap<>();
	         
	         for(int i = 0; i<mat.length; i++) {
	        	 for(int j = 0; j<mat[0].length; j++) {
	        		 
	        		 int idxValue = (i*mat[0].length)+j;
	        		 
	        		 map.put(idxValue,mat[i][j]);
	        		 
	        	 }
	         }
	         
	         
	         for(int i = 0; i<r; i++) {
	        	 for(int j = 0; j<c; j++) {
	        		 
	        		 int idxValue = (i*c)+j;
	        		 
	        		 ans[i][j] = map.get(idxValue);
	        	 }
	         }
	         
	         return ans;
	         
	        
	    }
}