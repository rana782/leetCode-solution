// LeetCode: Range Sum of BST (range-sum-of-bst)
// Submission ID: 1658304116
// Language: java
// Timestamp (UTC): 2025-06-09T06:00:47Z

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
    static int l,h;
    public static int solution(TreeNode root){
        if(root == null)return 0;
        
        if(root.val<l)return solution(root.right);
        else if(root.val>h)return solution(root.left);
        else return root.val+solution(root.left)+solution(root.right);
       
        
      
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        l = low;
        h = high;
        
        return solution(root);
    }
}