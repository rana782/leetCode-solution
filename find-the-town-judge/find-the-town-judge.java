// LeetCode: Find the Town Judge (find-the-town-judge)
// Submission ID: 1335117109
// Language: java
// Timestamp (UTC): 2024-07-27T13:21:12Z

class Solution {
    public int findJudge(int n, int[][] trust) {
        int ans[] = new int[n+1];

        for(int i =0; i<ans.length; i++){
            ans[i] = 0;
        }

        for(int i =0; i<trust.length; i++){
            int person[] = trust[i];

            ans[person[0]]-=1;
            ans[person[1]]+=1;
        }

        for(int i = 1; i<ans.length; i++){
            if(ans[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}