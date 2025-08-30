// LeetCode: Search in a Binary Search Tree (search-in-a-binary-search-tree)
// Submission ID: 1753129905
// Language: java
// Timestamp (UTC): 2025-08-30T05:51:03Z

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
    public static TreeNode solution(TreeNode root, int val){
        if(root == null) return null;
        
        if(root.val == val)return root;
        
        if(root.val<val){
            return solution(root.right,val);
        }
        
        return solution(root.left,val);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        
        
        return solution(root,val);
    }
}