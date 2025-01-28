// LeetCode: Maximum Total Importance of Roads (maximum-total-importance-of-roads)
// Submission ID: 1523262636
// Language: java
// Timestamp (UTC): 2025-01-28T13:22:11Z

class Solution {
   public class Pair implements Comparable<Pair>{
		int node;
		 int cost;
		 
		 Pair(int node, int cost){
			 this.node = node;
			 this.cost = cost;
		 }
		 
		 public int compareTo(Pair o) {
			 return this.cost-o.cost;
		 }
	}
	
public long maximumImportance(int n, int[][] roads) {
        int costArr[] = new int[n];
        
        for(int e[] : roads) {
        	costArr[e[0]]++;
        	costArr[e[1]]++;
    }
        
        ArrayList<Pair> schema = new ArrayList<>();
        
        for(int i = 0; i<n; i++) {
        	schema.add(new Pair(i,costArr[i]));
        }
        
        
        Collections.sort(schema,Collections.reverseOrder());
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int assignCost = n;
        for(Pair p : schema) {
        	map.put(p.node, assignCost);
             System.out.println(p.node +" "+assignCost);
        	assignCost--;
           
        }
        
        
        long output = 0;
        
        for(int e[] : roads) {
        	
        	long currCost = map.get(e[0])+map.get(e[1]);
        	output+=currCost;
        }
        
        return output;
        
        
        
}
}