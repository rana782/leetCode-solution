// LeetCode: Rectangle Area (rectangle-area)
// Submission ID: 1655095859
// Language: java
// Timestamp (UTC): 2025-06-05T20:16:03Z

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        // Area of the first rectangle
        int areaA = (ax2 - ax1) * (ay2 - ay1);

        // Area of the second rectangle
        int areaB = (bx2 - bx1) * (by2 - by1);

        // Find overlap rectangle coordinates
        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapArea = overlapWidth * overlapHeight;

        // Total area covered
        return areaA + areaB - overlapArea;
    }
}