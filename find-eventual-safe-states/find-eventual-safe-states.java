// LeetCode: Find Eventual Safe States (find-eventual-safe-states)
// Submission ID: 1518728416
// Language: java
// Timestamp (UTC): 2025-01-24T06:06:11Z

class Solution {
  	  public List<Integer> eventualSafeNodes(int[][] graph) {
	        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	        
	        for(int i = 0; i<graph.length; i++) {
	        	
	        	adjList.add(new ArrayList<>());
	        }
	        
	        
	        for(int i  = 0; i<graph.length; i++) {
	        	int nbrs[] = graph[i];
	        	
	        	for(int nbr : nbrs) {
	        		adjList.get(i).add(nbr);
	        	}
	        }
	        
	        
	        List<Integer> output = new ArrayList<>();
	        
	        
	        for(int i = 0; i<graph.length; i++) {
	        	boolean visited[] = new boolean[graph.length];
	        	boolean recStcak[] = new boolean[graph.length];
	        	if(!detectCycle(adjList,visited,recStcak,i)) {
	        		output.add(i);
	        	}
	        }
	        
	        
	        return output;
	    }
	  private boolean detectCycle(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recStack, int i) {
		    if (recStack[i]) return true; // Cycle detected
		    if (visited[i]) return false; // Node already processed, no cycle here

		    visited[i] = true;
		    recStack[i] = true;

		    for (int nbr : adjList.get(i)) {
		        if (detectCycle(adjList, visited, recStack, nbr)) {
		            return true;
		        }
		    }

		    recStack[i] = false; // Backtrack
		    return false;
		}

}