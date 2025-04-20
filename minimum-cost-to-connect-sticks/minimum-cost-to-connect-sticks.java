// LeetCode: Minimum Cost to Connect Sticks (minimum-cost-to-connect-sticks)
// Submission ID: 1612449498
// Language: java
// Timestamp (UTC): 2025-04-20T11:10:31Z

class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks.length == 1)return 0;

        int output = 0;

        PriorityQueue<Integer>pq = new PriorityQueue<>();

        for(int ele : sticks){
            pq.add(ele);
        }

        while(pq.size()!=1){
            int first = pq.poll();
            int sec = pq.poll();

            int cost = first+sec;

            output+=cost;
            pq.add(cost);
        }

        return output;
    }
}