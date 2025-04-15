// LeetCode: Diagonal Traverse II (diagonal-traverse-ii)
// Submission ID: 1607455503
// Language: java
// Timestamp (UTC): 2025-04-15T10:52:52Z

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer,List<Integer>>map = new TreeMap<>();
        
        int size = 0;
        
        for(int i = 0;i<nums.size(); i++) {
        	List<Integer>subAns = nums.get(i);
        	size+=subAns.size();
        	
        	for(int j = 0; j<subAns.size();j++) {
        		
        		if(map.containsKey(i+j))map.get(i+j).add(subAns.get(j));
        		
        		else {
        			List<Integer>list = new ArrayList<>();
        			list.add(subAns.get(j));
        			
        			map.put(i+j, list);
        			
        		}
        	}
        }
        
        int output[] = new int[size];
        
        int idx = 0;
        for(List<Integer>subAns : map.values()) {
        	
        	Collections.reverse(subAns);
        	
        	for(int ele : subAns)output[idx++] = ele;
        }
        
        return output;
    }
}