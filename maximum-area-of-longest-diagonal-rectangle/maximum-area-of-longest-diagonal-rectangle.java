// LeetCode: Maximum Area of Longest Diagonal Rectangle (maximum-area-of-longest-diagonal-rectangle)
// Submission ID: 1748394105
// Language: java
// Timestamp (UTC): 2025-08-26T01:55:01Z

class Solution {
    public static double findDiag(int len, int width){

        double output = Math.sqrt(len*len+width*width);
        return output;
    }

    public static int findArea(int len, int width){
        return len*width;
    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag  = 0;
        int output = 0;

        for(int d[] : dimensions){
            int len = d[0];
             int width = d[1];

             double currDiag = findDiag(len,width);
             if(currDiag>maxDiag){
                maxDiag = currDiag;
                output = findArea(len, width);
             }
             else if(currDiag == maxDiag){
                output = Math.max(output,findArea(len,width));
             }
        }

        return output;
    }
}