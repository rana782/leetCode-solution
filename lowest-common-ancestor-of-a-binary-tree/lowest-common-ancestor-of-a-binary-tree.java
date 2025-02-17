// LeetCode: Lowest Common Ancestor of a Binary Tree (lowest-common-ancestor-of-a-binary-tree)
// Submission ID: 1546309474
// Language: java
// Timestamp (UTC): 2025-02-17T14:53:41Z

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
   public static boolean solution(TreeNode root, int p, ArrayList<TreeNode> list) {
        if (root == null) return false;

        list.add(root); // Add the current node to the path

        // If we find the target node p, return true
        if (root.val == p) return true;

        // Recursively search in the left and right subtrees
        if (solution(root.left, p, list) || solution(root.right, p, list)) {
            return true;
        }

        // Backtrack if not found
        list.remove(list.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        // Find the paths from root to p and root to q
        solution(root, p.val, path1);
        solution(root, q.val, path2);

        TreeNode output = null;
        int i = 0;
        // Find the last common node in the paths
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) == path2.get(i)) {
                output = path1.get(i);  // Update output with the last common node
            } else {
                break;
            }
            i++;
        }

        return output;
    }
}