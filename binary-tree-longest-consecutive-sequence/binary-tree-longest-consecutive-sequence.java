// LeetCode: Binary Tree Longest Consecutive Sequence (binary-tree-longest-consecutive-sequence)
// Submission ID: 1616593892
// Language: java
// Timestamp (UTC): 2025-04-24T11:40:42Z

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
    static int maxi;
    public static void solution(TreeNode root, int currMax){
        if(root == null)return;

          if(root.left!=null && root.left.val == root.val+1){
            solution(root.left,currMax+1);
          }
          else{
            solution(root.left, 1);
          }

          if(root.right!=null && root.right.val == root.val+1)solution(root.right,currMax+1);
          else{
            solution(root.right,1);
          }
        maxi = Math.max(maxi,currMax);

    }
    public int longestConsecutive(TreeNode root) {
        if(root == null)return 0;

        maxi = 0;

        solution(root,1);

        return maxi;
    }
}