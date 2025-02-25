// LeetCode: Delete and Earn (delete-and-earn)
// Submission ID: 1554826778
// Language: java
// Timestamp (UTC): 2025-02-25T10:12:16Z

class Solution {
    public int deleteAndEarn(int[] nums) {
	        if(nums.length == 1) return nums[0];
	        
	        HashMap<Integer,Integer> map = new HashMap<>();
	        
	        int maxNum = Integer.MIN_VALUE;
	        
	        for(int i = 0; i<nums.length; i++) {
	        	maxNum = Math.max(maxNum , nums[i]);
	        	map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	        }
	        
	        int costStr[] = new int[maxNum+1];
	        
	        Arrays.fill(costStr,0);
	        
	        for(int i : map.keySet()) {
	        	costStr[i] = i*map.get(i);
	        }
	        
	        
	        int incSum = costStr[0];
	        int excSum = 0;
	        
	        for(int i = 1; i<costStr.length; i++) {
	        	
	        	int nayaIncSum = excSum+costStr[i];
	        	int nayaExcSum = Math.max(incSum, excSum);
	        	
	        	
	        	incSum = nayaIncSum;
	        excSum = nayaExcSum;
	        }
	        
	        return Math.max(incSum, excSum);

	        
	    }
}