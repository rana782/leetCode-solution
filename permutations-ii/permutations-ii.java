// LeetCode: Permutations II (permutations-ii)
// Submission ID: 1642161122
// Language: java
// Timestamp (UTC): 2025-05-23T13:16:23Z

class Solution {
   static List<List<Integer>>output;
    public static void solution(int nums[], boolean visited[],List<Integer>subAns){
        if(subAns.size()>=nums.length){
            output.add(new ArrayList<>(subAns));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited[i])continue;
            
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1])continue;

            visited[i] = true;
            subAns.add(nums[i]);
            solution(nums,visited,subAns);
            visited[i] = false;
            subAns.remove(subAns.size()-1);

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        output = new ArrayList<>();
        List<Integer>subAns = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];

        solution(nums,visited,subAns);

        System.out.println(output);
        return output;

    }
}