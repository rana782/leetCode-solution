// LeetCode: Minimum Depth of Binary Tree (minimum-depth-of-binary-tree)
// Submission ID: 1658035776
// Language: java
// Timestamp (UTC): 2025-06-08T21:10:03Z

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
    public static int solution(TreeNode root){
        
        
        if(root.left == null && root.right == null)return 1;
       int ls = Integer.MAX_VALUE;
        int rs = Integer.MAX_VALUE;
        
        if(root.left!=null)ls = 1+solution(root.left);
        if(root.right!=null)rs = 1+solution(root.right);
        
        return Math.min(rs,ls);
    }
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        
        return solution(root);
    }
}