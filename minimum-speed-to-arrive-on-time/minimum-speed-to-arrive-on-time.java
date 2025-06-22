// LeetCode: Minimum Speed to Arrive on Time (minimum-speed-to-arrive-on-time)
// Submission ID: 1672248405
// Language: java
// Timestamp (UTC): 2025-06-22T04:33:38Z

class Solution {
    public static boolean isPossible(int speed, int arr[], double hrs){
        double timeTaken = 0;

        for(int i = 0; i<arr.length; i++){
            if(i == arr.length-1){
                timeTaken+=(double)arr[i]/speed;
            }
            else{
                timeTaken+=Math.ceil((double)arr[i]/speed);
            }

            if(timeTaken>hrs)return false;
        }

        return timeTaken<=hrs;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int)1e7;

     

        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(isPossible(mid,dist,hour)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;


    }
}