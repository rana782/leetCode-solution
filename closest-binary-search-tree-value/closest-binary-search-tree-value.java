// LeetCode: Closest Binary Search Tree Value (closest-binary-search-tree-value)
// Submission ID: 1656295140
// Language: java
// Timestamp (UTC): 2025-06-07T06:35:58Z

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
    static int output;
    static double minDiff;
    public static void solution(TreeNode root,double target){
        if(root == null)return;
        
        double diff = Math.abs(target-root.val);
        if(diff<minDiff){
            minDiff = diff;
            output = root.val;
        }
        else if(diff == minDiff)output = Math.min(root.val,output);
        
        solution(root.left,target);
        solution(root.right,target);
       
    }
    public int closestValue(TreeNode root, double target) {
        output = Integer.MAX_VALUE;
        minDiff = Double.MAX_VALUE;
        solution(root,target);
        
        return output;
    }
}