// LeetCode: Count Good Triplets (count-good-triplets)
// Submission ID: 1606440699
// Language: java
// Timestamp (UTC): 2025-04-14T09:39:53Z

class Solution {

     
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int output = 0;

        int n = arr.length;
         for(int i = 0; i<n-2; i++){
            for(int j = i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    if(Math.abs(arr[i]-arr[j])<=a && Math.abs(arr[j]-arr[k])<=b && Math.abs(arr[i]-arr[k])<=c){

                        output++;
                    }
                }
            }
         }

         return output;
    }
}