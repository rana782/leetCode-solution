// LeetCode: Sqrt(x) (sqrtx)
// Submission ID: 1670498665
// Language: java
// Timestamp (UTC): 2025-06-20T12:19:52Z

class Solution {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;

        long ans = 0;

        while(low<=high){
            long mid = low+(high-low)/2;

            if(mid*mid<=x){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return (int)ans;
    }
}