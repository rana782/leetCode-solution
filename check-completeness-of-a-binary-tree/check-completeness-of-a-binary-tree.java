// LeetCode: Check Completeness of a Binary Tree (check-completeness-of-a-binary-tree)
// Submission ID: 1656951527
// Language: java
// Timestamp (UTC): 2025-06-07T19:01:37Z

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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)return true;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        boolean foundNull = false;
        
        while(!q.isEmpty()){
            TreeNode rem = q.poll();
            
            if(rem == null){
                foundNull = true;
            }
            else{
                if(foundNull)return false;
                q.add(rem.left);
                q.add(rem.right);
            }
        }
        
        return true;
    }
}