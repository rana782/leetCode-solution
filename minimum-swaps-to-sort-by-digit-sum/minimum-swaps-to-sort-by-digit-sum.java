// LeetCode: Minimum Swaps to Sort by Digit Sum (minimum-swaps-to-sort-by-digit-sum)
// Submission ID: 1638255799
// Language: java
// Timestamp (UTC): 2025-05-19T12:51:43Z

import java.util.*;

class Solution {
    public static class Pair implements Comparable<Pair> {
        int ele, originalIdx;

        Pair(int ele, int originalIdx) {
            this.ele = ele;
            this.originalIdx = originalIdx;
        }

        @Override
        public int compareTo(Pair o) {
            int sumA = getDigitSum(this.ele);
            int sumB = getDigitSum(o.ele);
            if (sumA != sumB) return sumA - sumB;
            return this.ele - o.ele;
        }
    }

    public static int getDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Step 1: Create an array of Pair(ele, originalIndex)
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // Step 2: Sort the array by digit sum and then value
        Arrays.sort(arr);

        // Step 3: Count minimum swaps using cycle detection
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i].originalIdx == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].originalIdx;
                cycleSize++;
            }

            swaps += (cycleSize - 1);
        }

        return swaps;
    }
}
