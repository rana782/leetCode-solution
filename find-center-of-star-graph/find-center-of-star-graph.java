// LeetCode: Find Center of Star Graph (find-center-of-star-graph)
// Submission ID: 1523234469
// Language: java
// Timestamp (UTC): 2025-01-28T12:48:15Z

class Solution {
     public int findCenter(int[][] edges) {
        return edges[0][0]==edges[1][0] || edges[0][0] ==edges[1][1]?edges[0][0]:edges[0][1];
    }
}