// LeetCode: Lonely Pixel I (lonely-pixel-i)
// Submission ID: 1611011417
// Language: java
// Timestamp (UTC): 2025-04-19T00:49:13Z

class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;

        int rowSum[] = new int[m];
         int colSum[] = new int[n];

         int output = 0;

         for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] == 'B'){
                        rowSum[i]++;
                        colSum[j]++;
                }
            }
         }


              for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] == 'B' && rowSum[i]+colSum[j] == 2){
                      output++;
                }
            }
         }

         return output;
    }
}