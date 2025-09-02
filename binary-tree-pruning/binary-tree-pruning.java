// LeetCode: Binary Tree Pruning (binary-tree-pruning)
// Submission ID: 1756622349
// Language: java
// Timestamp (UTC): 2025-09-02T05:09:12Z

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
    public static TreeNode solution(TreeNode root){
        if(root == null)return null;
        if(root.left == null && root.right == null && root.val == 0)return null;

        root.left = solution(root.left);
        root.right = solution(root.right);
        
            if(root.left == null && root.right == null && root.val == 0)return null;
        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        return solution(root);
    }
}