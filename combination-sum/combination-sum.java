// LeetCode: Combination Sum (combination-sum)
// Submission ID: 1352687566
// Language: java
// Timestamp (UTC): 2024-08-12T03:38:11Z

class Solution {
    public static void solution(int idx, int arr[], int target,List<Integer>curr,List<List<Integer>>output){
        if(target<0){
            return;
        }
        if(target == 0){
            output.add(new ArrayList(curr));
            return;
        }

        for(int i = idx; i<arr.length; i++){
            curr.add(arr[i]);
            solution(i,arr,target-arr[i],curr,output);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>curr = new ArrayList<>();
        List<List<Integer>>output = new ArrayList<>();
        solution(0,candidates,target,curr,output);
        return output;
    }
}