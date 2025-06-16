// LeetCode: Pascal's Triangle (pascals-triangle)
// Submission ID: 1665515577
// Language: java
// Timestamp (UTC): 2025-06-16T03:19:01Z

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>output = new ArrayList<>();
        
    int dp[][] = new int[numRows][numRows];
        
        dp[0][0] = 1;
        
        
        for(int i = 0; i<dp.length; i++){
            List<Integer>subAns = new ArrayList<>();
            
            for(int j = 0; j<=i; j++){
                if(j == 0 || j == i){
                    subAns.add(1);
                    dp[i][j] = 1;
                }
                
                else{
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                    subAns.add(dp[i][j]);
                }
            }
            
            output.add(subAns);
        }
        
        
        return output;
    }
}