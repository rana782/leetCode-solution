// LeetCode: Add One Row to Tree (add-one-row-to-tree)
// Submission ID: 1541716994
// Language: java
// Timestamp (UTC): 2025-02-13T12:36:33Z

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

    public static void getK(TreeNode root, int val, int k){
        if(root == null) return;
        if(k<=0) return;

        if(k == 1){

            if(root.left!=null){
                TreeNode curr = new TreeNode(val);
                curr.left = root.left;
                root.left = curr;
            }
            else{
               TreeNode curr = new TreeNode(val);
               root.left = curr; 
            }

            if(root.right!=null){
                TreeNode curr = new TreeNode(val);
                curr.right = root.right;
                root.right = curr;
            }
            else{
                TreeNode curr = new TreeNode(val);
                root.right = curr;
            }
        }

        getK(root.left,val,k-1);
        getK(root.right,val,k-1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode output = new TreeNode(val);
            output.left = root;
            return output;
        }

        getK(root,val,depth-1);

        return root;
    }
}