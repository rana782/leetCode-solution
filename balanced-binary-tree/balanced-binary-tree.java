// LeetCode: Balanced Binary Tree (balanced-binary-tree)
// Submission ID: 1539168427
// Language: java
// Timestamp (UTC): 2025-02-11T10:43:24Z

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
 class pair{
     int height;
     boolean isBal;
 }
class Solution {
    public pair check(TreeNode root){
        if(root == null){
            pair ans = new pair();
            ans.height = 0;
            ans.isBal = true;
            return ans;
        }

        pair ls = check(root.left);
         pair rs = check(root.right);

         boolean Bal = true;

         if(Math.abs(ls.height-rs.height)>1){
             Bal = false;
         }

         if(ls.isBal == false || rs.isBal == false){
             Bal = false;
         }

int hei = 1+Math.max(ls.height,rs.height);
         pair res = new pair();
                res.height = hei;
                res.isBal = Bal;
                return res;
    }
    public boolean isBalanced(TreeNode root) {
        pair ans = new pair();
        ans = check(root);
        return ans.isBal;
    }
}