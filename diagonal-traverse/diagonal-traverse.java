// LeetCode: Diagonal Traverse (diagonal-traverse)
// Submission ID: 1338523083
// Language: java
// Timestamp (UTC): 2024-07-30T14:28:38Z

class Solution {
   	  	  public static int[] findDiagonalOrder(int[][] mat) {
	        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
	        
	        for(int i = 0; i<mat.length; i++) {
	        	for(int j = 0; j<mat[0].length; j++) {
	        		int index = i+j;
	        		if(map.containsKey((index))){
	        			ArrayList<Integer> arr =map.get(index);
	        		
	        			arr.add(mat[i][j]);
	        			map.put(index, arr);
	        		
	        		}
	        		else {
	        			ArrayList<Integer> arr = new ArrayList<>();
	        			
	        			arr.add(mat[i][j]);
	        			map.put(index, arr);
	        			
	        		}
	        	}
	        }
	        
	        int output[] = new int[mat.length*mat[0].length];
	        int k = 0;
	        
	        for(int i = 0; i<map.size(); i++) {
	        	ArrayList<Integer> arr = map.get(i);
	        	
	        	if(i%2 == 0) {
	        		for(int j = arr.size()-1; j>=0; j--) {
	        		
	        			output[k++] = arr.get(j);
	        		}
	        	}
	        	else {
	        		for(int j = 0; j<arr.size(); j++) {
	        			
	        			output[k++] = arr.get(j);
	        		}
	        	}
	        }
	        return output;
	    }
}