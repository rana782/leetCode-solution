// LeetCode: Count and Say (count-and-say)
// Submission ID: 1658966665
// Language: java
// Timestamp (UTC): 2025-06-09T18:28:02Z

class Solution {
    public static String getStr(String str){
        StringBuilder output = new StringBuilder();
        
        int count = 1;
        
        for(int i = 0; i<str.length()-1; i++){
            if(str.charAt(i)!=str.charAt(i+1)){
                output.append(count);
                output.append(str.charAt(i));
                count = 1;
            }
            else{
                count++;
            }
        
        }
        
        if(count>0){
            output.append(count);
            output.append(str.charAt(str.length()-1));
        }
        
        return output.toString();
    }
    public String countAndSay(int n) {
        String dp[] = new String[n+1];
        
        dp[1] = "1";
        
        
        for(int i = 2; i<=n; i++){
            String str = dp[i-1];
            String ans = getStr(str);
            System.out.println(ans);
            dp[i] = ans;
        }
        
        return dp[n];
    }
}