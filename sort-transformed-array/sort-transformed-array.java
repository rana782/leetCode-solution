// LeetCode: Sort Transformed Array (sort-transformed-array)
// Submission ID: 1615003888
// Language: java
// Timestamp (UTC): 2025-04-22T20:24:40Z

class Solution {

    public static int fxn(int a, int b, int c, int x){
        return (a*x*x)+(b*x)+c;
    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int output[] = new int[n];

        for(int i = 0; i<nums.length; i++){

            int ans = fxn(a,b,c,nums[i]);
            output[i] = ans;
        }

        Arrays.sort(output);

        return output;
    }
}