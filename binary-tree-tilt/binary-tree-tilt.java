// LeetCode: Binary Tree Tilt (binary-tree-tilt)
// Submission ID: 1511518326
// Language: java
// Timestamp (UTC): 2025-01-17T13:35:17Z

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
    static  int output;
	public static int solution(TreeNode root) {
		if(root == null)return 0;
		
		if(root.left == null && root.right == null) return root.val;
		
		int leftSubTreeSum = solution(root.left);
		int rightSubTreeSum = solution(root.right);
		
		output+=Math.abs(rightSubTreeSum-leftSubTreeSum);
		return root.val+leftSubTreeSum+rightSubTreeSum;
	}
public int findTilt(TreeNode root) {
        output = 0;
        solution(root);
        return output;
    }

}