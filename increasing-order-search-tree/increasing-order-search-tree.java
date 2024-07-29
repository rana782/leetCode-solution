// LeetCode: Increasing Order Search Tree (increasing-order-search-tree)
// Submission ID: 1337575121
// Language: java
// Timestamp (UTC): 2024-07-29T17:43:04Z

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
    TreeNode ans = new TreeNode();
    TreeNode temp = ans;
    public TreeNode increasingBST(TreeNode root) {
        
        if(root == null){
            return null;
        }
         increasingBST(root.left);
         TreeNode newNode = new TreeNode(root.val);
         temp.right = newNode;
         temp = temp.right;

         increasingBST(root.right);

         return ans.right;

          
         
    }
}