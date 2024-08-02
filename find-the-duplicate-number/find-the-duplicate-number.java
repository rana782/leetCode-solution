// LeetCode: Find the Duplicate Number (find-the-duplicate-number)
// Submission ID: 1342178777
// Language: java
// Timestamp (UTC): 2024-08-02T18:21:40Z

class Solution {
    public int findDuplicate(int[] nums) {
   boolean visited[] = new boolean[nums.length];

   for(int i  = 0; i<visited.length; i++){
    visited[i] = false;
   }

   int ans = 0;
    for(int i :nums){
        if(visited[i]){
            ans = i;
            break;
        }
        else{
            visited[i] = true;
        }
    }

    return ans;
    }
}