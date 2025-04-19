// LeetCode: Fixed Point (fixed-point)
// Submission ID: 1611046774
// Language: java
// Timestamp (UTC): 2025-04-19T02:23:39Z

class Solution {
    public int fixedPoint(int[] arr) {

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == i)return i;
        }
        return -1;
    }
}