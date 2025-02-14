// LeetCode: Construct Binary Tree from Inorder and Postorder Traversal (construct-binary-tree-from-inorder-and-postorder-traversal)
// Submission ID: 1542818457
// Language: java
// Timestamp (UTC): 2025-02-14T10:54:34Z

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
      public static TreeNode solution(int in[], int post[], int isi, int iei, int psi, int pei, Map<Integer, Integer> inMap) {
        if (isi > iei || psi > pei) return null;

        int rootVal = post[pei];
        TreeNode root = new TreeNode(rootVal);

        int idx = inMap.get(rootVal); // Get index in inorder directly
        int leftSize = idx - isi;

        // Left subtree
        root.left = solution(in, post, isi, idx - 1, psi, psi + leftSize - 1, inMap);
        // Right subtree
        root.right = solution(in, post, idx + 1, iei, psi + leftSize, pei - 1, inMap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return solution(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inMap);
    }
}