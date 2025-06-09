// LeetCode: How Many Apples Can You Put into the Basket (how-many-apples-can-you-put-into-the-basket)
// Submission ID: 1658934871
// Language: java
// Timestamp (UTC): 2025-06-09T17:58:58Z

class Solution {
    public int maxNumberOfApples(int[] weight) {
        int currWt = 0;
        Arrays.sort(weight);
        
        int count = 0;
        
        for(int wt : weight){
            if((currWt+=wt)<=5000){
                count++;
            }
            else{
                break;
            }
        }
        
        return count;
    }
}