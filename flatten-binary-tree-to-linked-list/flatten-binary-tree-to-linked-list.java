// LeetCode: Flatten Binary Tree to Linked List (flatten-binary-tree-to-linked-list)
// Submission ID: 1539247610
// Language: java
// Timestamp (UTC): 2025-02-11T12:29:44Z

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
   static ArrayList<Integer> lists;
    public static void postOrder(TreeNode root){
        if(root == null) return;
        lists.add(root.val);
        postOrder(root.left);
        
        postOrder(root.right);
    }
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;

        lists = new ArrayList<>();
        postOrder(root);
        System.out.print(lists);

        TreeNode ref = root;
        root.left = null;

        for(int i = 1; i<lists.size(); i++){
            int ele = lists.get(i);
            TreeNode currentNode = new TreeNode(ele);
            ref.right = currentNode;
            ref = currentNode;
        }
    }
}