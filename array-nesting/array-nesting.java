// LeetCode: Array Nesting (array-nesting)
// Submission ID: 1514929854
// Language: java
// Timestamp (UTC): 2025-01-20T18:34:26Z

class Solution {
   	int length;
  public int arrayNesting(int[] nums) {
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       
       for(int i = 0; i<nums.length; i++) {
    	   graph.add(new ArrayList<>());
       }
       
       
       for(int i = 0; i<nums.length; i++) {
    	   
    	   graph.get(i).add(nums[i]);
    	   graph.get(nums[i]).add(i);
       }
       
       HashSet<Integer> visited = new HashSet<>();
       int output = 1;
       for(int i = 0; i<nums.length; i++) {
    	   
    	   if(!visited.contains(i)) {
    		   length = 0;
    		   dfs(graph,visited,i);
    		   
    		   output = Math.max(output, length);
    	   }
       }
       
       return output;
    }
	private void dfs(ArrayList<ArrayList<Integer>> graph, HashSet<Integer> visited, int i) {
	// TODO Auto-generated method stub
		visited.add(i);
		length++;
		
		for(int nbrs : graph.get(i)) {
			if(!visited.contains(nbrs)) {
				dfs(graph, visited, nbrs);
			}
		}
		
	
}
}