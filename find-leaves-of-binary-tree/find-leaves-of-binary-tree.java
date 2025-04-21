// LeetCode: Find Leaves of Binary Tree (find-leaves-of-binary-tree)
// Submission ID: 1613710985
// Language: java
// Timestamp (UTC): 2025-04-21T15:58:58Z

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

   public TreeNode dfs(TreeNode root, List<Integer> subAns) {
    if (root == null) return null;
    if (root.left == null && root.right == null) {
        subAns.add(root.val);
        return null; 
    }
    root.left = dfs(root.left, subAns);
    root.right = dfs(root.right, subAns);
    return root;
}

public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    while (root != null) {
        List<Integer> sub = new ArrayList<>();
        root = dfs(root, sub);
        res.add(sub);
    }
    return res;
}

    }
