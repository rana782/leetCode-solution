// LeetCode: Divide Chocolate (divide-chocolate)
// Submission ID: 1672230277
// Language: java
// Timestamp (UTC): 2025-06-22T04:07:00Z

class Solution {
    public static boolean isPossible(int minSum, int arr[], int k){
        int count = 0;
        int currSum = 0;

        for(int i = 0; i<arr.length; i++){
           currSum+=arr[i];
           if(currSum>=minSum){
            count++;
            currSum = 0;
           }
        }

        return count>=k+1;
    }
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = Integer.MAX_VALUE;
        int high = 0;

        for(int ele : sweetness){
            low = Math.min(low,ele);
            high+=ele;
        }

        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(isPossible(mid,sweetness, k)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
}