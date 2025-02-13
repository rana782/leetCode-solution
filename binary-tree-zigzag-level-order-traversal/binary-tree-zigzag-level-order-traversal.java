// LeetCode: Binary Tree Zigzag Level Order Traversal (binary-tree-zigzag-level-order-traversal)
// Submission ID: 1541832962
// Language: java
// Timestamp (UTC): 2025-02-13T14:36:51Z

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         if(root == null){
            List<List<Integer>> output = new ArrayList<>();
            return output;
         }


 List<List<Integer>> output = new ArrayList<>();

 Queue<TreeNode> q = new LinkedList<>();
 q.add(root);
int count = 0;
 while(q.size()!=0){
    
    int size = q.size();
    List<Integer>subAns = new ArrayList<>();
    while(size--!=0){
        TreeNode rem = q.poll();
        subAns.add(rem.val);
        if(rem.left!=null)q.add(rem.left);
        if(rem.right!=null)q.add(rem.right);
    }
    if(count%2 == 0) output.add(subAns);
    else{
        Collections.reverse(subAns);
        output.add(subAns);
    }
    count++;
 }


 return output;

    }
}