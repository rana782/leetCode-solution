// LeetCode: Find Minimum Time to Reach Last Room I (find-minimum-time-to-reach-last-room-i)
// Submission ID: 1631011712
// Language: java
// Timestamp (UTC): 2025-05-11T12:09:29Z

class Solution {
    public static class Pair implements Comparable<Pair>{
        int row,col,time;

        Pair(int row, int col, int time){
            this.row = row;
             this.col = col;
             this.time = time;
        }

        public int compareTo(Pair o){
            return this.time-o.time;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
                    int n = moveTime.length;
                    int m = moveTime[0].length;

                    boolean visited[][] = new boolean[n][m]; 

                    PriorityQueue<Pair>pq = new PriorityQueue<>();
                    int output = 0;
                    int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
                    pq.add(new Pair(0,0,0));

                    while(pq.size()!=0){
                        int size = pq.size();

                        
                            Pair rem = pq.poll();
                            if (visited[rem.row][rem.col]) continue;
                                visited[rem.row][rem.col] = true;

                            if(rem.row == n-1 && rem.col == m-1)return rem.time;

                          

                                    for(int d[] : dir){
                                        int nRow = rem.row+d[0];
                                        int nCol = rem.col+d[1];

                                        if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && visited[nRow][nCol] == false){
                                            int currTime = moveTime[nRow][nCol];

                                            pq.add(new Pair(nRow,nCol,Math.max(rem.time+1,currTime+1)));

                                        }
                                    }

                        

                       

                    }    

                     return -1;                                                                                           
    }
}