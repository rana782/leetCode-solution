// LeetCode: Three Consecutive Odds (three-consecutive-odds)
// Submission ID: 1523318748
// Language: java
// Timestamp (UTC): 2025-01-28T14:22:20Z

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3) return false;

        for(int i = 1; i<arr.length-1; i++){
            if(arr[i]%2!= 0 && arr[i-1]%2!=0 && arr[i+1]%2!=0)return true;
                  
            
        }

        return false;
    }
}