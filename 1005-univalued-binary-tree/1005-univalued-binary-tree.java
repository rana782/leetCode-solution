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
    public static boolean solution(TreeNode root){
        if(root == null)return true;
        if(root.left!=null && root.val!=root.left.val)return false;
        if(root.right!=null && root.val!=root.right.val)return false;

        return solution(root.left)&&solution(root.right);
    }
    public boolean isUnivalTree(TreeNode root) {
        return solution(root);
    }
}