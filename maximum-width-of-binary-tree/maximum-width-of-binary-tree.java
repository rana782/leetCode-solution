// LeetCode: Maximum Width of Binary Tree (maximum-width-of-binary-tree)
// Submission ID: 1665538211
// Language: java
// Timestamp (UTC): 2025-06-16T03:52:29Z

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
    public class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // To prevent overflow

            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                int idx = curr.index - minIndex; // Normalize to avoid large numbers

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (curr.node.left != null)
                    queue.offer(new Pair(curr.node.left, 2 * idx));
                if (curr.node.right != null)
                    queue.offer(new Pair(curr.node.right, 2 * idx + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
