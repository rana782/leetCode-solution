// LeetCode: Arranging Coins (arranging-coins)
// Submission ID: 1670140246
// Language: java
// Timestamp (UTC): 2025-06-20T05:32:02Z

class Solution {
    public int arrangeCoins(int n) {
        int low = 1;
        int high = n;
        int ans = 0;

        while(low<=high){
            int mid = low+(high-low)/2;

            long coinUsed = (long)mid*(mid+1)/2;
            

          if(coinUsed == n)return mid;
          else if(coinUsed<n){
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