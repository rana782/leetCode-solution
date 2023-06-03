// LeetCode: Sum Multiples (sum-multiples)
// Submission ID: 963122459
// Language: java
// Timestamp (UTC): 2023-06-03T17:41:40Z

class Solution {
    public int sumOfMultiples(int n) {
        int sum =0;
        for(int i =1; i<=n ; i++){
            if(i%3==0 || i%5==0 || i%7==0){
                sum+=i;
            }
        }
        return sum;
    }
}