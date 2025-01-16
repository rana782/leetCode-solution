// LeetCode: Brick Wall (brick-wall)
// Submission ID: 1510526140
// Language: java
// Timestamp (UTC): 2025-01-16T14:41:15Z

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
    	
    	int  n = wall.size();
    	
    	HashMap<Integer,Integer>  map = new HashMap<>();
    	
    	for(List<Integer> rows : wall) {
    		
    		int edges = 0;
    		
    		for(int i : rows) {
    			edges+=i;
    			map.put(edges,map.getOrDefault(edges,0)+1);
    		}
    		
    		map.remove(edges);
    	}
    	
    	
    	if(map.size() == 0) return n;
    	
    	int maxEdges = 0;
    	
    	for(int i : map.values()) {
    		maxEdges = Math.max(maxEdges, i);
    	}
    	
    	return n-maxEdges;
        
    }
}