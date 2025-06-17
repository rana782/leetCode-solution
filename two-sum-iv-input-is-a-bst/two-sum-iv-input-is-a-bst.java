// LeetCode: Two Sum IV - Input is a BST (two-sum-iv-input-is-a-bst)
// Submission ID: 1666581270
// Language: java
// Timestamp (UTC): 2025-06-17T00:31:03Z

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
    static List<Integer>inOrder;
    
    public static void solution(TreeNode root){
        if(root == null)return;
        
        solution(root.left);
        inOrder.add(root.val);
        solution(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        
        inOrder = new ArrayList<>();
        
        solution(root);
        
        int start = 0;
        int end = inOrder.size()-1;
        
        while(start<end){
            
            int sum = inOrder.get(start)+inOrder.get(end);
            
            if(sum == k)return true;
            
            else if(sum>k)end--;
            else{
                start++;
            }
        }
        
        return false;
    }
}