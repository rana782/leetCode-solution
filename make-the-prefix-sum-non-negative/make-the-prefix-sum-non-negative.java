// LeetCode: Make the Prefix Sum Non-negative (make-the-prefix-sum-non-negative)
// Submission ID: 1755403719
// Language: java
// Timestamp (UTC): 2025-09-01T04:26:16Z

import java.util.*;

class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // store negatives
        long sum = 0;
        int ops = 0;

        for (int x : nums) {
            sum += x;
            if (x < 0) minHeap.offer(x);    // track negative choices

            while (sum < 0) {               // fix by removing the most harmful negatives
                sum -= minHeap.poll();      // subtracting a negative increases sum
                ops++;
            }
        }
        return ops;
    }
}
