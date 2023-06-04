// LeetCode: Longest String Chain (longest-string-chain)
// Submission ID: 1557113956
// Language: java
// Timestamp (UTC): 2025-02-27T12:28:18Z

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int [n+1];
        Arrays.sort(words,(a,b)->Integer.compare(a.length(), b.length()));
        System.out.println(Arrays.toString(words));
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i = 1;i < n; i++){
            for(int j = i-1;j >= 0; j--){
                if(isPossible(words,i,j)){
                    dp[i] = Math.max(1+dp[j],dp[i]);
                    ans = Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }
    public boolean isPossible(String[] words,int i,int j){
        String s = words[i];
        String p = words[j];
        if(s.length() - p.length() == 1){
            boolean bool = false;
            for(int first = 0,second = 0;first < s.length() && second < p.length(); first++,second++){
                if(s.charAt(first) != p.charAt(second)){
                    if(bool)return false;
                    bool = true;
                    second--;
                }
            }
            return true;
        }
        return false;
    }
}