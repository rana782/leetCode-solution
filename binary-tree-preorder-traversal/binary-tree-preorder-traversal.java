// LeetCode: Binary Tree Preorder Traversal (binary-tree-preorder-traversal)
// Submission ID: 1339710622
// Language: java
// Timestamp (UTC): 2024-07-31T15:54:37Z

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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        ans.add(root.val);
         preorderTraversal(root.left);
          preorderTraversal(root.right);
          return ans;

    }
}