// LeetCode: Widest Vertical Area Between Two Points Containing No Points (widest-vertical-area-between-two-points-containing-no-points)
// Submission ID: 1607750865
// Language: java
// Timestamp (UTC): 2025-04-15T16:57:03Z

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
       Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));

       int maxDist = 0;

       for(int i = 0; i<points.length-1; i++){
        int pt1 = points[i][0];
        int pt2 = points[i+1][0];

        maxDist = Math.max(maxDist,pt2-pt1);
       }

       return maxDist; 
    }
}