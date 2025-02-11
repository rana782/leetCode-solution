// LeetCode: Count Good Nodes in Binary Tree (count-good-nodes-in-binary-tree)
// Submission ID: 1539268541
// Language: java
// Timestamp (UTC): 2025-02-11T12:55:43Z

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
    static int count;
    public static void fxn(TreeNode root, int max){
        if(root == null) return;

        if(root.val>=max){
            count++;
            max = root.val;
        }

        fxn(root.left,max);
        fxn(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        count = 0;
        int max = Integer.MIN_VALUE;
        fxn(root,max);
        return count;
    }
}