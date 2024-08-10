// LeetCode: Sort an Array (sort-an-array)
// Submission ID: 1351159990
// Language: java
// Timestamp (UTC): 2024-08-10T16:48:12Z

class Solution {
    public int[] sortArray(int[] nums) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
		 for(int i : nums) {
			 pq.add(i);
		 }
		 
		 int ans[] = new int[nums.length];
		 int ind = 0;
		 while(!pq.isEmpty()) {
			 ans[ind++] = pq.poll();
		 }
		 return ans;
    }
}