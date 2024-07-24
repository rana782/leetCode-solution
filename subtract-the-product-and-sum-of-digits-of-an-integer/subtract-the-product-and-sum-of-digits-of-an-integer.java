// LeetCode: Subtract the Product and Sum of Digits of an Integer (subtract-the-product-and-sum-of-digits-of-an-integer)
// Submission ID: 1332038013
// Language: java
// Timestamp (UTC): 2024-07-24T16:26:07Z

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
         int product = 1;

         while(n!=0){
            int rem = n%10;
            product = product*rem;
            sum+=rem;
            n = n/10;
         }
         return product-sum;
    }
}