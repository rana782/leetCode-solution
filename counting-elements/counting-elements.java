// LeetCode: Counting Elements (counting-elements)
// Submission ID: 1614908862
// Language: java
// Timestamp (UTC): 2025-04-22T18:18:36Z

class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer>set = new HashSet<>();

        for(int ele : arr){
            set.add(ele);
        }

        int output = 0;

        for(int ele : arr){
            if(set.contains(ele+1))output++;
        }

        return output;
    }
}