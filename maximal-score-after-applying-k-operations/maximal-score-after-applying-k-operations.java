// LeetCode: Maximal Score After Applying K Operations (maximal-score-after-applying-k-operations)
// Submission ID: 1508086655
// Language: java
// Timestamp (UTC): 2025-01-14T07:27:41Z

class Solution {
    public long maxKelements(int[] nums, int k) {
	        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
	        long maxScore = 0;
	        for(int i : nums) {
	        	pq.add((long)i);
	        }
	        
	        while(k!=0 && pq.size()!=0) {
	        	long removed = pq.poll();
	        	maxScore+=removed;
	        	long insert = (long) Math.ceil(removed/3.0);
	        	pq.add(insert);
	        	k--;
	        }
	        
	        return maxScore;
	    }
}