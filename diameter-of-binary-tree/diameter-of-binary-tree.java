// LeetCode: Diameter of Binary Tree (diameter-of-binary-tree)
// Submission ID: 1510382560
// Language: java
// Timestamp (UTC): 2025-01-16T11:43:19Z

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
class Pair {
    int height;
    int diameter;
}

class Solution {
    public Pair calculateDiameter(TreeNode root) {
        if (root == null) {
            Pair output = new Pair();
            output.height = 0;
            output.diameter = 0;
            return output;
        }

        // Recursively calculate for left and right subtrees
        Pair leftResult = calculateDiameter(root.left);
        Pair rightResult = calculateDiameter(root.right);

        // Calculate height of the current node
        int currentHeight = 1 + Math.max(leftResult.height, rightResult.height);

        // Calculate diameter
        int diameterThroughRoot = leftResult.height + rightResult.height;
        int maxDiameterSoFar = Math.max(leftResult.diameter, rightResult.diameter);
        int currentDiameter = Math.max(diameterThroughRoot, maxDiameterSoFar);

        // Prepare the result for the current node
        Pair result = new Pair();
        result.height = currentHeight;
        result.diameter = currentDiameter;

        return result;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return calculateDiameter(root).diameter;
    }
}
