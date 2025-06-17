// LeetCode: Diet Plan Performance (diet-plan-performance)
// Submission ID: 1667140711
// Language: java
// Timestamp (UTC): 2025-06-17T12:31:36Z

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        int points = 0;
        int sum = 0;
        
        for(int i = 0; i<k; i++){
            sum+=calories[i];
        }
        
        if(sum>upper)points++;
        else if(sum<lower)points--;

        
        
        for(int i = k; i<calories.length; i++){
            sum+=calories[i];
            sum-=calories[i-k];
            
            if(sum>upper)points++;
            else if(sum<lower)points--;
        }
        
        return points;
    }
}