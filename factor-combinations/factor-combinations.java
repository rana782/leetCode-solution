// LeetCode: Factor Combinations (factor-combinations)
// Submission ID: 1619995515
// Language: java
// Timestamp (UTC): 2025-04-28T07:11:22Z

class Solution {
    static List<List<Integer>> output;

    public static void solution(int currNum, int target, List<Integer> subAns) {
        if (target == 1) {
            if (subAns.size() > 1) { 
                output.add(new ArrayList<>(subAns));
            }
            return;
        }

        for (int i = currNum; i <= target; i++) {
            if (target % i == 0) {
                subAns.add(i);
                solution(i, target / i, subAns);
                subAns.remove(subAns.size() - 1);
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        output = new ArrayList<>();
        List<Integer> subAns = new ArrayList<>();
        solution(2, n, subAns);
        return output;
    }
}
