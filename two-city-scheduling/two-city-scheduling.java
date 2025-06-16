// LeetCode: Two City Scheduling (two-city-scheduling)
// Submission ID: 1665678489
// Language: java
// Timestamp (UTC): 2025-06-16T06:24:28Z

class Solution {
    public int twoCitySchedCost(int[][] costs) {
       Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
       int n = costs.length;
        int totalCost = 0;
        for(int i = 0; i<costs.length; i++){
           if(i<n/2)totalCost+=costs[i][0];
           else{
            totalCost+=costs[i][1];
           }
        }

        return totalCost;
    }
}