// LeetCode: Maximum Number of Integers to Choose From a Range I (maximum-number-of-integers-to-choose-from-a-range-i)
// Submission ID: 1598892192
// Language: java
// Timestamp (UTC): 2025-04-06T19:58:17Z

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer>set = new HashSet<>();
        for(int nums : banned){
            set.add(nums);
        }

        int count = 0;
        int currSum = 0;

        for(int i = 1; i<=n; i++){
            if(!set.contains(i)){
                if(currSum+i<=maxSum){
                    currSum+=i;
                    count++;
                }
                else{
                    return count;
                }
            }
        }

        return count;
    }
}