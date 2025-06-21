// LeetCode: Kth Missing Positive Number (kth-missing-positive-number)
// Submission ID: 1671470190
// Language: java
// Timestamp (UTC): 2025-06-21T11:52:27Z

class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int ele : arr){
            if(ele<=k)k+=1;
            else{
                return k;
            }
        }

        return k;
    }
}