// LeetCode: Find the Smallest Divisor Given a Threshold (find-the-smallest-divisor-given-a-threshold)
// Submission ID: 1671422143
// Language: java
// Timestamp (UTC): 2025-06-21T10:50:45Z

class Solution {

    public static int getThres(int div, int nums[]){
        int output = 0;

        for(int ele : nums){
            output+=Math.ceil((double)ele/div);
        }

        return output;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);

        int low = 1;
        int high = nums[nums.length-1];

        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            int th = getThres(mid,nums);

            if(th<=threshold){
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