// LeetCode: Find a Corresponding Node of a Binary Tree in a Clone of That Tree (find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree)
// Submission ID: 1541783271
// Language: java
// Timestamp (UTC): 2025-02-13T13:49:11Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
 public static TreeNode getRef(TreeNode cloned, TreeNode target){
    if(cloned ==  null) return null;

    if(cloned.val == target.val) return cloned;
   TreeNode ls =  getRef(cloned.left,target);
    TreeNode rs = getRef(cloned.right,target);

    return ls!=null?ls:rs;
 }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
      return getRef(cloned,target);
    }
}