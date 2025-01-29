// LeetCode: Average Waiting Time (average-waiting-time)
// Submission ID: 1524434943
// Language: java
// Timestamp (UTC): 2025-01-29T15:00:31Z

class Solution {
public double averageWaitingTime(int[][] customers) {
    double currentTime = 0;
    double totalWaitingTime = 0;
    
    for (int i = 0; i < customers.length; i++) {
        int arrivalTime = customers[i][0];
        int cookTime = customers[i][1];

        // Update currentTime: If the chef is free, start when the customer arrives.
        currentTime = Math.max(currentTime, arrivalTime) + cookTime;
        
        // Waiting time = Time when order is completed - Arrival time
        totalWaitingTime += (currentTime - arrivalTime);
    }
    
    return totalWaitingTime / customers.length;
}

}