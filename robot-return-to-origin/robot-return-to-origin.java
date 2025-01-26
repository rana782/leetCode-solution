// LeetCode: Robot Return to Origin (robot-return-to-origin)
// Submission ID: 1521085434
// Language: java
// Timestamp (UTC): 2025-01-26T13:00:55Z

class Solution {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col =0;

        for(int i = 0;i<moves.length(); i++){

            char ch = moves.charAt(i);

            if(ch == 'U'){
                row-=1;

            }

            else if(ch == 'D'){

                row+=1;
            }

            else if(ch == 'L'){
                col-=1;
            }

            else{
                col+=1;
            }
        }

        return row == 0 && col == 0;
    }
}