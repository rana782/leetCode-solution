// LeetCode: First Missing Positive (first-missing-positive)
// Submission ID: 1608920833
// Language: java
// Timestamp (UTC): 2025-04-16T20:27:50Z

class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean visited[] = new boolean[nums.length+1];

        Arrays.fill(visited,false);

        for(int ele : nums){
            if(ele>0 && ele<=nums.length)visited[ele] = true;
        }

        for(int i = 1; i<visited.length; i++){
            if(!visited[i])return i;
        }

        return nums.length+1;
    }
}