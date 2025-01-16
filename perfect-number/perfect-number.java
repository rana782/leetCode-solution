// LeetCode: Perfect Number (perfect-number)
// Submission ID: 1510407470
// Language: java
// Timestamp (UTC): 2025-01-16T12:20:36Z

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
        int sum = 1;
        for(int i = 2; i*i<=num; i++){
              if(num%i == 0){
                int quo = num/i;
                if(quo == i){
                   sum = sum+i;
                }

                else{
                    sum = sum+i+quo;
                }
                
               
              }
        }

        return sum==num;
    }
}