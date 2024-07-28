// LeetCode: Sum of Even Numbers After Queries (sum-of-even-numbers-after-queries)
// Submission ID: 1336416456
// Language: java
// Timestamp (UTC): 2024-07-28T16:23:06Z

class Solution {

    public static int getEvenSum(int arr[]){
        int ans = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i]%2 == 0){
                ans+=arr[i];
            }
        }
        return ans;
    }
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int output[] = new int[nums.length];

        for(int i =0; i<queries.length; i++){
            int command[] = queries[i];
            int val = command[0];
            int index = command[1];

            nums[index]+=val;

            output[i] = getEvenSum(nums);
        }
        return output;
    }
}