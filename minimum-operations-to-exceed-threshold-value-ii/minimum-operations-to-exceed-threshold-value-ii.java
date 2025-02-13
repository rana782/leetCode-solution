// LeetCode: Minimum Operations to Exceed Threshold Value II (minimum-operations-to-exceed-threshold-value-ii)
// Submission ID: 1541502746
// Language: java
// Timestamp (UTC): 2025-02-13T08:23:06Z

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i =0; i<nums.length; i++){
            pq.add((long)nums[i]);
        }

        int ops = 0;

        while(pq.size()>1 && pq.peek()<k){
         long num1 = pq.poll();
        long num2 = pq.poll();
        long num3 = (2*num1)+num2;

            pq.add(num3);
            ops++;
        }

       return pq.peek()>=k ? ops : -1;
    }
}