// LeetCode: Find All Duplicates in an Array (find-all-duplicates-in-an-array)
// Submission ID: 1342200332
// Language: java
// Timestamp (UTC): 2024-08-02T18:41:45Z

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        boolean visited[] = new boolean[nums.length+1];
        ArrayList<Integer> result =  new ArrayList<>();

        for(int i =0; i<visited.length; i++){
            visited[i] = false;
        }

        for(int i : nums){
            if(visited[i]){
                result.add(i);
            }
            else{
                visited[i] = true;
            }
        }
        return result;
    }
}