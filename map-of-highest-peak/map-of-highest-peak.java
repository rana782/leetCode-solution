// LeetCode: Map of Highest Peak (map-of-highest-peak)
// Submission ID: 1516498258
// Language: java
// Timestamp (UTC): 2025-01-22T05:13:56Z

class Solution {
   public class Pair{
		int row;
		int col;
		 int wt;
		 
		 Pair(int row, int col, int wt){
			 this.row = row;
			  this.col = col;
			  this.wt = wt;
			  
		 }
	}
	
	  public int[][] highestPeak(int[][] isWater) {
		  
		  Queue<Pair> pq = new LinkedList<>();
	        for(int i = 0; i<isWater.length; i++) {
	        	for(int j = 0;j<isWater[0].length; j++) {
	        		
	        		if(isWater[i][j] == 1) {
	        			isWater[i][j] = 0;
	        			pq.add(new Pair(i, j, 0));
	        		}
	        		
	        		else {
	        			isWater[i][j] = -1;
	        		}
	        		
	        	}
	        }
	        
	        
	        
	        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
	        
	        while(pq.size()!=0) {
	        	Pair rem = pq.poll();
	        	
	        	for(int d[] : dir) {
	        		int nRow = rem.row+d[0];
	        		int nCol = rem.col+d[1];
	        		
	        		if(nRow>=0 && nRow<isWater.length && nCol>=0 && nCol<isWater[0].length && isWater[nRow][nCol] == -1) {
	        			isWater[nRow][nCol] = rem.wt+1;
	        			
	        			pq.add(new Pair(nRow, nCol, isWater[nRow][nCol]));
	        		}
	        	}
	        }
	        
	        
	        return isWater;
	    }
}