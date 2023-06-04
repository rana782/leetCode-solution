// LeetCode: Find the Winner of the Circular Game (find-the-winner-of-the-circular-game)
// Submission ID: 1351775525
// Language: java
// Timestamp (UTC): 2024-08-11T07:03:51Z

class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer>arr = new ArrayList<Integer>();
        for(int i = 1; i<=n; i++){
            arr.add(i);
        }

        int i = 0;
        while(arr.size()!=1){
            int index = (i+k-1)%arr.size();
            arr.remove(index);
           i = index;
        }
        return arr.get(0);
    }
}