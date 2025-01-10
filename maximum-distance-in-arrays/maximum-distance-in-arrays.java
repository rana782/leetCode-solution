// LeetCode: Maximum Distance in Arrays (maximum-distance-in-arrays)
// Submission ID: 1503834251
// Language: java
// Timestamp (UTC): 2025-01-10T07:44:29Z

class Solution {
    	  public int maxDistance(List<List<Integer>> arrays) {
		  List<Integer> firstArray = arrays.get(0);
	        int max = firstArray.get(firstArray.size()-1);
	        int min = firstArray.get(0);
	        int diff = 0;
	        
	        for(int i = 1; i<arrays.size(); i++) {
	        	List<Integer> getArray = arrays.get(i);
	        	int diff1 = Math.abs(max-getArray.get(0));
	        	int diff2 = Math.abs(min-getArray.get(getArray.size()-1));
	        	
	        	diff = Math.max(diff1, Math.max(diff2,diff));
                max = Math.max(max,getArray.get(getArray.size()-1) );
	        	min = Math.min(min, getArray.get(0));
	        }
	        
	        return diff;
	        
	       
	    }
}