// LeetCode: Kth Smallest Element in a BST (kth-smallest-element-in-a-bst)
// Submission ID: 1542901248
// Language: java
// Timestamp (UTC): 2025-02-14T13:00:41Z

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

    public static void traverse(TreeNode root, int k, ArrayList<Integer> output){
        if(root == null) return;

        traverse(root.left,k,output);
        output.add(root.val);
        if(output.size() == k) return;
        traverse(root.right,k,output);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        traverse(root,k,list);

        return list.get(k-1);
    }
}