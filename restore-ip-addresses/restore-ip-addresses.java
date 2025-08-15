// LeetCode: Restore IP Addresses (restore-ip-addresses)
// Submission ID: 1736074890
// Language: java
// Timestamp (UTC): 2025-08-15T12:15:11Z

class Solution {
    public static boolean isValid(String str){
        if(str.length()>1 && str.charAt(0) == '0')return false;

        int num = Integer.valueOf(str);
        if(num>255)return false;

        return true;
    }
    static List<String>output;
    public static void solution(int idx, String s, String currAns,int partition){
        if(partition>4)return;
            if(idx == s.length() && partition == 4){
                output.add(currAns.substring(0,currAns.length()-1));
                return;
            }

        for(int i = 1; i<=3 && i+idx<=s.length(); i++){
            String substr = s.substring(idx,idx+i);
            if(isValid(substr)){
                solution(idx+i,s,currAns+substr+".",partition+1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
       output = new ArrayList<>();
       solution(0,s,"",0);
       return output;
    }
}