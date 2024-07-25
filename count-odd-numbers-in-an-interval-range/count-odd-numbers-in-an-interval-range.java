// LeetCode: Count Odd Numbers in an Interval Range (count-odd-numbers-in-an-interval-range)
// Submission ID: 1332867015
// Language: java
// Timestamp (UTC): 2024-07-25T10:24:13Z

class Solution {
    public int countOdds(int low, int high) {
        if(low%2!= 0 && high%2!= 0){
           return ((high-low+1)/2)+1;
        }
       return ((high-low+1)/2);
        
    }
}