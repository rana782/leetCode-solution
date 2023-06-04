// LeetCode: Sum of Unique Elements (sum-of-unique-elements)
// Submission ID: 1355761706
// Language: java
// Timestamp (UTC): 2024-08-14T19:01:24Z

class Solution {
    public int sumOfUnique(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i : nums) {
	        	if(map.containsKey(i)) {
	        		map.put(i,map.get(i)+1);
	        	}
	        	else {
	        		map.put(i,1);
	        	}
	        }
	        int count =0;
	        
	        for(int i : nums) {
	        	if(map.containsKey(i)&&map.get(i)==1) {
	        		count+=i;
	        	}
	        }
	        return count;
    }
}