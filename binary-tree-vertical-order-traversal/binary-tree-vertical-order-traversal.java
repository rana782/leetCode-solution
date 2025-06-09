// LeetCode: Binary Tree Vertical Order Traversal (binary-tree-vertical-order-traversal)
// Submission ID: 1659003130
// Language: java
// Timestamp (UTC): 2025-06-09T19:08:38Z

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
  
    public static class Pair{
        TreeNode node;
        int height;
        
        Pair(TreeNode node, int height){
            this.node = node;
            this.height = height;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>>output = new ArrayList<>();
        if(root == null)return output;
        
       TreeMap<Integer,List<Integer>>map = new TreeMap<>();
        
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair rem = q.poll();
            
            List<Integer>l = map.getOrDefault(rem.height,new ArrayList<>());
            l.add(rem.node.val);
            map.put(rem.height,l);
            
            if(rem.node.left!=null){
                q.add(new Pair(rem.node.left,rem.height-1));
            }
            if(rem.node.right!=null){
                q.add(new Pair(rem.node.right,rem.height+1));
            }
        }
        
         
        
        
        
        
        for(List<Integer>l : map.values()){
            output.add(l);
        }
        
        
        
        return output;
            
            
            
        
    }
}