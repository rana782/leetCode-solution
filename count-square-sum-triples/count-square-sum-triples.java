// LeetCode: Count Square Sum Triples (count-square-sum-triples)
// Submission ID: 1332886496
// Language: java
// Timestamp (UTC): 2024-07-25T10:46:30Z

class Solution {
    public int countTriples(int n) {
       int ans = 0;
        for(int i =1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                int c_sq = i*i+j*j;
                int c = (int)Math.sqrt(c_sq);

                if(c<=n && c*c == c_sq){
                    ans++;
                }
            }
        }
        return ans;
    }
}