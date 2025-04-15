// LeetCode: Arithmetic Subarrays (arithmetic-subarrays)
// Submission ID: 1607478555
// Language: java
// Timestamp (UTC): 2025-04-15T11:30:10Z

class Solution {
	public static boolean isArithmatic(List<Integer>subAns,int diff) {
		
		for(int i = subAns.size()-1; i>0; i--) {
			if(subAns.get(i)-subAns.get(i-1)!=diff)return false;
		}
		
		return true;
	}
	
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> output = new ArrayList<>();
        
        for(int i = 0; i<l.length; i++) {
        	List<Integer>list = new ArrayList<>();
        	
        	for(int j = l[i]; j<=r[i]; j++) {
        		
        		list.add(nums[j]);
        		
        		
        	}
        	Collections.sort(list);
        	
        	int diff = list.get(1)-list.get(0);
        	
        	output.add(isArithmatic(list, diff));
        	
        }
        
        return output;
    }
}