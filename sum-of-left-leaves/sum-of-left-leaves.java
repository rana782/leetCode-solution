// LeetCode: Sum of Left Leaves (sum-of-left-leaves)
// Submission ID: 1666539137
// Language: java
// Timestamp (UTC): 2025-06-16T22:38:35Z

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
    static int output;
    public static void solution(TreeNode root){
      
        if(root == null)return;
        
        if(root.left!=null && root.left.left == null && root.left.right == null)output+=root.left.val;
        
        solution(root.left);
        solution(root.right);
        }
    public int sumOfLeftLeaves(TreeNode root) {
        
        
        output = 0;
        solution(root);
        
        return output;
    }
}