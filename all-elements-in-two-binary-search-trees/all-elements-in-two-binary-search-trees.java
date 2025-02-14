// LeetCode: All Elements in Two Binary Search Trees (all-elements-in-two-binary-search-trees)
// Submission ID: 1542956093
// Language: java
// Timestamp (UTC): 2025-02-14T14:12:11Z

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
    public static void traverse(TreeNode root,List<Integer>list){
        if(root == null) return;

        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>output = new ArrayList<>();
         traverse(root1,output);
         traverse(root2,output);

         Collections.sort(output);

         return output;
    }
}