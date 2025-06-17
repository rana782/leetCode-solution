// LeetCode: Two Sum BSTs (two-sum-bsts)
// Submission ID: 1666685611
// Language: java
// Timestamp (UTC): 2025-06-17T03:58:36Z

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
    public static void solution(TreeNode root,HashSet<Integer>set){
        if(root == null)return;
        
        solution(root.left,set);
        set.add(root.val);
        solution(root.right,set);
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        
        
        HashSet<Integer>set1 = new HashSet<>();
        HashSet<Integer>set2 = new HashSet<>();
        
        solution(root1,set1);
        solution(root2,set2);
        
        for(int ele : set1){
            if(set2.contains(target-ele))return true;
        }
        
        return false;
        
    }
}