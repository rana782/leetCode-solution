// LeetCode: Maximum Number of Pairs in Array (maximum-number-of-pairs-in-array)
// Submission ID: 1351160836
// Language: java
// Timestamp (UTC): 2024-08-10T16:49:03Z

class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
		        for(int i : nums) {
		        	if(map.containsKey(i)) {
		        		map.put(i,map.get(i)+1);
		        	}
		        	else {
		        		map.put(i,1);
		        	}
		        }
		        int count = 0;
		        for(int i : nums) {
		        	if(map.containsKey(i)&&map.get(i)>=2) {
		        		count++;
		        		map.put(i,map.get(i)-2);
		        	}
		        }
		        
		        int single = nums.length-2*count;
		        int ans[] = new int[2];
		        
		        ans[0] = count;
		        ans[1] = single;
		        return ans; 
    }
}