// LeetCode: Deepest Leaves Sum (deepest-leaves-sum)
// Submission ID: 1669006434
// Language: java
// Timestamp (UTC): 2025-06-19T05:26:19Z

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
    public int deepestLeavesSum(TreeNode root) {
        HashMap<Integer,Integer>map = new HashMap<>();
        
        Queue<TreeNode>q = new LinkedList<>();
        
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                TreeNode rem = q.poll();
               map.put(level,map.getOrDefault(level,0)+rem.val);
                
                if(rem.left!=null)q.add(rem.left);
                if(rem.right!=null)q.add(rem.right);
            }
            level++;
        }
        
        return map.get(level-1);
    }
}