// LeetCode: Minimum Number of Arrows to Burst Balloons (minimum-number-of-arrows-to-burst-balloons)
// Submission ID: 1603939662
// Language: java
// Timestamp (UTC): 2025-04-11T18:52:37Z

class Solution {
    public int findMinArrowShots(int[][] points) {

        if(points.length == 1) return 1;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

        int count = 0;

        int idx = 0;

        while(idx<points.length){
            int endPt = points[idx][1];

            while(idx+1<points.length && points[idx+1][0]<=endPt){
                idx++;
            }
            count++;
            idx+=1;
        }

        return count;


    }
}