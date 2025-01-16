// LeetCode: Minimum Absolute Difference in BST (minimum-absolute-difference-in-bst)
// Submission ID: 1510046507
// Language: java
// Timestamp (UTC): 2025-01-16T04:27:26Z

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

        public static void inOrder(TreeNode root, ArrayList<Integer> ansArray) {
    if (root == null) return;
    inOrder(root.left, ansArray);
    ansArray.add(root.val);
    inOrder(root.right, ansArray);
}
    public int getMinimumDifference(TreeNode root) {
        
          ArrayList<Integer> output = new ArrayList<>();
    inOrder(root, output);

    int minDiffAns = Integer.MAX_VALUE;
    for (int i = 0; i < output.size() - 1; i++) {
        int diff = output.get(i + 1) - output.get(i);
        minDiffAns = Math.min(minDiffAns, diff);
    }

    return minDiffAns;
    }
}