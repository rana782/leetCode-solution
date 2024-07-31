// LeetCode: Average of Levels in Binary Tree (average-of-levels-in-binary-tree)
// Submission ID: 1339712905
// Language: java
// Timestamp (UTC): 2024-07-31T15:56:55Z

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
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
             double d = 0.0;
             int level = 0;
             while(size-->0){
                 TreeNode ele = q.poll();
                 d = d+ele.val;
                 level++;
                 if(ele.left!=null){
                     q.add(ele.left);
                 }
                   if(ele.right!=null){
                     q.add(ele.right);
                 }
             }
             ans.add(d/level);
        }
         return ans;
       
    }
    
}