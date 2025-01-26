// LeetCode: Second Minimum Node In a Binary Tree (second-minimum-node-in-a-binary-tree)
// Submission ID: 1521159123
// Language: java
// Timestamp (UTC): 2025-01-26T14:31:39Z

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

    public static void traverse(TreeNode root, HashSet<Integer> set){
        if(root == null) return;

        traverse(root.left,set);
        set.add(root.val);
        traverse(root.right,set);
    }
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();

        traverse(root,set);

        if(set.size() == 0 || set.size() == 1) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : set){
            pq.add(i);
        }

        pq.poll();

        return pq.poll();
    }
}