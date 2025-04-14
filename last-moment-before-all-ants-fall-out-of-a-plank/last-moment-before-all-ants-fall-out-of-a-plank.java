// LeetCode: Last Moment Before All Ants Fall Out of a Plank (last-moment-before-all-ants-fall-out-of-a-plank)
// Submission ID: 1606989003
// Language: java
// Timestamp (UTC): 2025-04-14T20:53:59Z

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);

        int ans1 = Integer.MIN_VALUE;

        if(left.length!=0)ans1 = left[left.length-1]-0;

        int ans2 = Integer.MIN_VALUE;

        if(right.length!=0)ans2 = n-right[0];

        return Math.max(ans1,ans2);
    }
}