// LeetCode: Find Largest Value in Each Tree Row (find-largest-value-in-each-tree-row)
// Submission ID: 1509711142
// Language: java
// Timestamp (UTC): 2025-01-15T18:53:34Z

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
    public List<Integer> largestValues(TreeNode root) {
		 List<Integer> output = new ArrayList<>();
		 if(root == null) return output;
	         Queue<TreeNode> q = new LinkedList<>();
	         
	         q.add(root);
	         
	         while(q.size()!=0) {
	        	 int size = q.size();
	        	 
	        	 int maxEle = Integer.MIN_VALUE;
	        	 
	        	 while(size--!=0) {
	        		 TreeNode rem = q.poll();
	        		 if(rem.left!=null) q.add(rem.left);
	        		 if(rem.right!=null) q.add(rem.right);
	        		 
	        		 maxEle = Math.max(maxEle, rem.val);
	        	 }
	        	 
	        	 output.add(maxEle);
	         }
	         
	         return output;
	         
	    }
}