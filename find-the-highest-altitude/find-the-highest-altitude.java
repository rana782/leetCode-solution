// LeetCode: Find the Highest Altitude (find-the-highest-altitude)
// Submission ID: 1335937103
// Language: java
// Timestamp (UTC): 2024-07-28T06:40:30Z

class Solution {
    public int largestAltitude(int[] gain) {
       int ans = 0;
        int curr = 0;
        for(Integer i: gain){
            curr+=i;
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}