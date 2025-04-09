// LeetCode: Remove Stones to Minimize the Total (remove-stones-to-minimize-the-total)
// Submission ID: 1601464140
// Language: java
// Timestamp (UTC): 2025-04-09T07:59:39Z

class Solution {
   public int minStoneSum(int[] piles, int k) {
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	        
	        for(int ele : piles) {
	        	pq.add(ele);
	        }
	        
	        while(k!=0) {
	        	int num = pq.poll();
	        	
	        num = num-num/2;
	        	pq.add(num);
	        	k--;
	        }
	        
	        int sum = 0;
	        
	        while(pq.size()!=0) {
	        	sum+=pq.poll();
	        }
	        
	        return sum;
	    }
}