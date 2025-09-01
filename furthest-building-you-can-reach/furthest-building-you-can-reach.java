// LeetCode: Furthest Building You Can Reach (furthest-building-you-can-reach)
// Submission ID: 1755385279
// Language: java
// Timestamp (UTC): 2025-09-01T04:01:33Z

import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // diffs tentatively using ladders
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                minHeap.offer(diff);              // assign a ladder for now
                if (minHeap.size() > ladders) {   // too many ladders used -> pay smallest with bricks
                    bricks -= minHeap.poll();
                    if (bricks < 0) return i;     // cannot cover this step
                }
            }
        }
        return heights.length - 1;
    }
}
