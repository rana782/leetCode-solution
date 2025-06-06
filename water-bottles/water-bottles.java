// LeetCode: Water Bottles (water-bottles)
// Submission ID: 1656058304
// Language: java
// Timestamp (UTC): 2025-06-06T21:42:10Z

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int org = numBottles;
        int output = 0;
        
        while(numBottles>=numExchange){
            int full = numBottles/numExchange;
            int rem = numBottles%numExchange;
            
            output+=full;
            numBottles = rem+full;
        }
        
        output+=org;
        
        return output;
    }
}