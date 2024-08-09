// LeetCode: Combination Sum III (combination-sum-iii)
// Submission ID: 1349568770
// Language: java
// Timestamp (UTC): 2024-08-09T04:50:01Z

class Solution {

    public static void getCombination(int idx,int k, int[] candidates, int amsf, int target,List<Integer>curr, List<List<Integer>>output) {
		if(idx == candidates.length) {
			if(amsf == target) {
                if(curr.size() == k)
				output.add(new ArrayList<>(curr));
			}
			return;
		}
		
		curr.add(candidates[idx]);
		getCombination(idx+1,k, candidates, amsf+candidates[idx], target, curr, output);
		curr.remove(curr.size()-1);
		getCombination(idx+1,k, candidates, amsf, target, curr, output);
	}
    public List<List<Integer>> combinationSum3(int k, int n) {
int arr[] = {1,2,3,4,5,6,7,8,9};
        List<Integer> curr = new ArrayList<>();
		 List<List<Integer>> output = new ArrayList<>();
         getCombination(0, k,arr, 0, n, curr, output);
         return output;
    }
}