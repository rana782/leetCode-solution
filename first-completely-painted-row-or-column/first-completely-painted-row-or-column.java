// LeetCode: First Completely Painted Row or Column (first-completely-painted-row-or-column)
// Submission ID: 1514602742
// Language: java
// Timestamp (UTC): 2025-01-20T13:34:21Z

class Solution {
   public class Pair{
		int row;
		int col;
		
		Pair(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	 public int firstCompleteIndex(int[] arr, int[][] mat) {
	        // map the elements with its row and col
		 
		 HashMap<Integer,Pair> map = new HashMap<>();
		 
		 
		 int row = mat.length;
		  int col = mat[0].length;
		  
		  for(int i = 0; i<row; i++) {
			  for(int j = 0; j<col; j++) {
				  
				  map.put(mat[i][j],new Pair(i,j));
			  }
		  }
		  
		  int rowPaint[] = new int[row];
		  
		  int colPaint[] = new int[col];
		  
		  for(int i = 0; i<arr.length; i++) {
			  Pair index = map.get(arr[i]);
			  rowPaint[index.row]++;
			  colPaint[index.col]++;
			  
			  if(rowPaint[index.row] == col || colPaint[index.col] == row) return i;
		  }
		  
		  
		  return -1;
	    }
}