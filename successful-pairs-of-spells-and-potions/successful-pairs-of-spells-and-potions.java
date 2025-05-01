// LeetCode: Successful Pairs of Spells and Potions (successful-pairs-of-spells-and-potions)
// Submission ID: 1622892125
// Language: java
// Timestamp (UTC): 2025-05-01T15:22:43Z

class Solution {
public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            long num = spells[i]; // Use long to avoid overflow
            // Calculate ceiling of success / num
            long target = (success + num - 1) / num; // Ceiling division: (success / num) rounded up

            // Binary search to find the largest index where potions[mid] < target
            int floorIdx = -1;
            int low = 0;
            int high = potions.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (potions[mid] < target) {
                    floorIdx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Number of potions >= target is from floorIdx + 1 to end
            output[i] = potions.length - (floorIdx + 1);
        }

        return output;
    }
}