// LeetCode: Lucky Numbers in a Matrix (lucky-numbers-in-a-matrix)
// Submission ID: 1340237123
// Language: java
// Timestamp (UTC): 2024-08-01T04:22:32Z

class Solution {
	 public static List<Integer> luckyNumbers (int[][] matrix) {
	        ArrayList<Integer>  output = new ArrayList<>();
	         ArrayList<Integer>  minRow = new ArrayList<>();
	          ArrayList<Integer>  maxCol = new ArrayList<>();

	          int row = matrix.length;
	          int col = matrix[0].length;

	          for(int i= 0 ; i<row; i++){
	             int min = Integer.MAX_VALUE;
	            for(int j = 0; j<col; j++){
	            	
	            	
	               if(matrix[i][j]<min){
	            	  
	                min = matrix[i][j];
	               }
	            }
	            minRow.add(min);
	          }


	          for(int j = 0; j<col; j++){
	            int max = Integer.MIN_VALUE;
	            for(int i = 0; i<row; i++){
	        
	                if(matrix[i][j]>max){
	                
	                    max = matrix[i][j];
	                }
	            }
//	
	            maxCol.add(max);
	          }
	        

	        for(int i = 0; i<row; i++){
	            for(int j = 0; j<col; j++){
	            	
	                if(matrix[i][j] == minRow.get(i) && matrix[i][j]==maxCol.get(j)){
	                
	                    output.add(matrix[i][j]);
	                }
	            }
	           
	        }
	          
	        
	         return output;

	    }
}