// LeetCode: Max Sum of a Pair With Equal Sum of Digits (max-sum-of-a-pair-with-equal-sum-of-digits)
// Submission ID: 1540434134
// Language: java
// Timestamp (UTC): 2025-02-12T11:49:44Z

class Solution {
  	 public static int maximumSum(int[] nums) {
	        if(nums.length == 1) return -1;
	        
	        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
	        
	        for(int i = 0;i<nums.length; i++) {
	        	int sum = sumOfDigit(nums[i]);
	        	
	        	if(map.containsKey(sum)) {
	        		map.get(sum).add(i);
	        	}
	        	
	        	else {
	        		ArrayList<Integer> list = new ArrayList<>();
	        		list.add(i);
	        		map.put(sum, list);
	        	}
	        }
	        
	        
	         //max
	        int output = -1;
	        
	        for(int sum : map.keySet()) {
	        	
	        	if(map.get(sum).size()>=2) {
	        		ArrayList<Integer> list = map.get(sum);
	        		 PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        		
	        		for(int ele : list) {
	        			pq.add(nums[ele]);
	        		}
	        		
	        		int currSum = pq.poll()+pq.poll();
	        		output = Math.max(currSum, output);
	        	}
	        }
	        
	        return output;
	    }

	private static int sumOfDigit(int i) {
		int sum = 0;
		
		while(i!=0) {
			int rem = i%10;
			sum+=rem;
			i = i/10;
		}
		
		return sum;
	}
}