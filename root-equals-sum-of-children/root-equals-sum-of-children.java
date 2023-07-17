// LeetCode: Root Equals Sum of Children (root-equals-sum-of-children)
// Submission ID: 996741137
// Language: java
// Timestamp (UTC): 2023-07-17T14:16:45Z

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
    public boolean checkTree(TreeNode root) {
        if(root.val == root.left.val+root.right.val){
            return true;
        }
        return false;
    }
}