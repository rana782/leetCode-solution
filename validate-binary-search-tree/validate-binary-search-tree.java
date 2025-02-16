// LeetCode: Validate Binary Search Tree (validate-binary-search-tree)
// Submission ID: 1544986060
// Language: java
// Timestamp (UTC): 2025-02-16T10:55:13Z

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
    public static boolean solution(TreeNode root, long min, long max){
        if(root == null) return true;
         if(root.val<=min || root.val>=max) return false;
        boolean isLeftOk = solution(root.left,min,root.val);
        boolean isRightOk = solution(root.right,root.val,max);

        return isLeftOk && isRightOk;
    }
    public boolean isValidBST(TreeNode root) {
        return solution(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}