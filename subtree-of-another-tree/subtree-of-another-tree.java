// LeetCode: Subtree of Another Tree (subtree-of-another-tree)
// Submission ID: 1667135987
// Language: java
// Timestamp (UTC): 2025-06-17T12:25:46Z

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
    
    public static boolean isSimilar(TreeNode root1,TreeNode root2){
        
        if(root1 == null || root2 == null){
            if(root1 == null && root2 == null)return true;
            
            return false;
        }
        
        if(root1.val == root2.val && isSimilar(root1.left,root2.left) && isSimilar(root1.right,root2.right))return true;
        
        return false;
    }
    
    
    public static boolean solution(TreeNode root,TreeNode subRoot){
        if(root == null)return false;
        
        if(root.val == subRoot.val){
            if(isSimilar(root,subRoot))return true;
        }
        
        boolean ls = solution(root.left,subRoot);
        boolean rs = solution(root.right,subRoot);
        
        return ls||rs;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        
        return solution(root,subRoot);
    }
}