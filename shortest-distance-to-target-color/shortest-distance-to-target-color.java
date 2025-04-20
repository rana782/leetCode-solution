// LeetCode: Shortest Distance to Target Color (shortest-distance-to-target-color)
// Submission ID: 1612558323
// Language: java
// Timestamp (UTC): 2025-04-20T13:49:02Z

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;

        int leftDist[][] = new int[n][4];
        for(int i = 0; i<n; i++){
            Arrays.fill(leftDist[i],-1);
        }

        

        for(int i = 0; i<n; i++){
            int colr = colors[i];

            leftDist[i][colr] = 0;

            if(i>0){
                     for(int col = 1; col<=3; col++){
                if(leftDist[i-1][col]!=-1 && col!=colr)leftDist[i][col] = leftDist[i-1][col]+1;
            }
            }

           
        }


        int rightDist[][] = new int[n][4];
        for(int i = 0; i<n; i++){
            Arrays.fill(rightDist[i],-1);
        }

        for(int i = n-1; i>=0; i--){

            int colr = colors[i];
            rightDist[i][colr] = 0;

            if(i+1<n){

                for(int col = 1; col<=3; col++){

                    if(rightDist[i+1][col]!=-1 && col!=colr)rightDist[i][col] = rightDist[i+1][col]+1;
                }
            }
        }

        List<Integer>output = new ArrayList<>();

        for(int i = 0; i<queries.length; i++){
            int idx = queries[i][0];
            int colr = queries[i][1];

            int temp = Math.min(leftDist[idx][colr] == -1 ? Integer.MAX_VALUE : leftDist[idx][colr],rightDist[idx][colr] == -1 ? Integer.MAX_VALUE : rightDist[idx][colr] );

            output.add(temp == Integer.MAX_VALUE ? -1 : temp);
        }

        return output;
    }
}