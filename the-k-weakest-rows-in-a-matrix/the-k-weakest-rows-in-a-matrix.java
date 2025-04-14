// LeetCode: The K Weakest Rows in a Matrix (the-k-weakest-rows-in-a-matrix)
// Submission ID: 1606935954
// Language: java
// Timestamp (UTC): 2025-04-14T19:31:02Z

class Solution {
  	public static class Pair implements Comparable<Pair>{
		int row;
		int sol;
		
		Pair(int row, int sol){
			this.row = row;
			this.sol = sol;
		}
		
		public int compareTo(Pair o) {
			if(this.sol == o.sol) {
				return this.row-o.row;
			}
			
			return this.sol-o.sol;
		}
	}
	
	  public int[] kWeakestRows(int[][] mat, int k) {
	        
		  
		  PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		  
		  for(int i = 0; i<mat.length; i++) {
			  
			  int col[] = mat[i];
			  int sol = 0;
			  
			  for(int ele : col) {
				  if(ele == 1)sol++;
			  }
			  
			  Pair p = new Pair(i,sol);
			  
			  if(pq.size() == k) {
				  if(pq.peek().sol>p.sol) {
					  pq.poll();
					  
					  pq.add(p);
				  }
			  }

                else {
					  pq.add(p);
				  }
		  }
		  
		  
		  int output[] = new int[k];
		  
		  while(pq.size()!=0) {
			  output[k-1] = pq.poll().row;
			  k--;
		  }
		  
		  return output;
	    }
}