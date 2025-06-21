// LeetCode: Capacity To Ship Packages Within D Days (capacity-to-ship-packages-within-d-days)
// Submission ID: 1671457385
// Language: java
// Timestamp (UTC): 2025-06-21T11:35:48Z

class Solution {

    public static boolean canPossible(int cap, int weights[],int days){
                  int count = 1;
                  int wt = 0;

                  for(int i = 0; i<weights.length; i++){
                    if(wt+weights[i]>cap){
                        count++;
                        wt = 0;
                    }
                    wt+=weights[i];
                    if(count>days)return false;
                  }

                  return true;

    }
    public int shipWithinDays(int[] weights, int days) {
      int low = Integer.MIN_VALUE;

      
        int high = 0;
        for(int ele : weights){
            high+=ele;
            low = Math.max(ele,low);
        }


        int cap = -1;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(canPossible(mid,weights,days)){
                cap = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return cap;
    }
}