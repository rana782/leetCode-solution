// LeetCode: Minimum Cost Homecoming of a Robot in a Grid (minimum-cost-homecoming-of-a-robot-in-a-grid)
// Submission ID: 1639070597
// Language: java
// Timestamp (UTC): 2025-05-20T07:40:33Z

class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int startX = startPos[0];
        int startY = startPos[1];

        int endX = homePos[0];
        int endY = homePos[1];

        int totalCost = 0;

        if(endX>=startX){
            for(int i = startX+1; i<=endX; i++){
               totalCost+=rowCosts[i];
            }
        }
        else{
            for(int i = startX-1; i>=endX; i--){
                totalCost+=rowCosts[i];
            }
        }



        if(endY>=startY){
            for(int i = startY+1; i<=endY; i++){
                totalCost+=colCosts[i];
            }
        }
        else{
            for(int i = startY-1; i>=endY; i--){
                totalCost+=colCosts[i];
            }
        }

        return totalCost;
    }
}