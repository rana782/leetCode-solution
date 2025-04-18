// LeetCode: Rotating the Box (rotating-the-box)
// Submission ID: 1610815485
// Language: java
// Timestamp (UTC): 2025-04-18T18:41:14Z

class Solution {
	public static class Pair{
		int row;
		 int col;
		 
		 Pair(int row, int col){
			 this.row = row;
			 this.col = col;
		 }
	}
	
    public char[][] rotateTheBox(char[][] boxGrid) {
        
    	int m = boxGrid.length;
    	int n = boxGrid[0].length;
    	
    	
    	for(int i = 0; i<m; i++) {
    		for(int j = n-1; j>=0; j--) {
    			
    			if(boxGrid[i][j] == '#') {
    				Pair nextStep = getNext(i,j,boxGrid);
    				
    				if(nextStep.row!=-1) {
    					
    					int row = nextStep.row;
    					int col = nextStep.col;
    					
    					boxGrid[row][col] = '#';
    					boxGrid[i][j] = '.';
    				}
    			}
    		}
    	}
    	
    	
    	char output[][] = new char[n][m];
    	
    	for(int i = 0; i<m; i++) {
    		for(int j = 0; j<n; j++) {
    			output[j][m-i-1] = boxGrid[i][j];
    		}
    	}
    	
    	return output;
    	
    	
    	
    }

	private Pair getNext(int i, int j, char[][] boxGrid) {
		Pair output = new Pair(-1,-1);
		
		for(int col = j+1; col<boxGrid[0].length; col++) {
				
			if(boxGrid[i][col] == '#')break;
			
			else if(boxGrid[i][col] == '*')break;
			
			else {
				output.row = i;
				output.col = col;
			}
		}
		
		return output;
	}
}