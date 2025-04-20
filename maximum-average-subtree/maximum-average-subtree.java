// LeetCode: Maximum Average Subtree (maximum-average-subtree)
// Submission ID: 1612436246
// Language: java
// Timestamp (UTC): 2025-04-20T10:51:56Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static class Pair{
        int totalSum;
        int totalNode;

        Pair(int totalSum, int totalNode){
            this.totalSum = totalSum;
            this.totalNode = totalNode;
        }
    }

    static double ans;

    public static Pair solution(TreeNode root){
        if(root == null)return new Pair(0,0);

        Pair ls = solution(root.left);
        Pair rs = solution(root.right);

        int totalSum = root.val+ls.totalSum+rs.totalSum;
        int totalNode = 1+ls.totalNode+rs.totalNode;

        double avg = (double)totalSum/totalNode;
        ans = Math.max(ans, avg);

        return new Pair(totalSum,totalNode);
    }
    public double maximumAverageSubtree(TreeNode root) {
        ans = Double.MIN_VALUE;

        solution(root);
        return ans;
    }
}