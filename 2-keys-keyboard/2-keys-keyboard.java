// LeetCode: 2 Keys Keyboard (2-keys-keyboard)
// Submission ID: 1507141006
// Language: java
// Timestamp (UTC): 2025-01-13T10:33:14Z

class Solution {
    public int minSteps(int n) {
        int ans = 0;
        for(int i = 2; i*i<=n;){
            if(n%i == 0){
                ans+=i;
                n= n/i;
            }
            else{
                i++;
            }
        }

        if(n!=1) ans+=n;
        return ans;
    }
}