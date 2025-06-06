// LeetCode: Minimum Time Visiting All Points (minimum-time-visiting-all-points)
// Submission ID: 1655723906
// Language: java
// Timestamp (UTC): 2025-06-06T13:58:45Z

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int output = 0;
        
        for(int i = 0;i<points.length-1; i++){
            int s[] = points[i];
            int t[] = points[i+1];
                
                
                output+=Math.max(Math.abs(s[0]-t[0]),Math.abs(s[1]-t[1]));
        }
        
        return output;
    }
}