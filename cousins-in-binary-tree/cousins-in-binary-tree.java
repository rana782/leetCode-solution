// LeetCode: Cousins in Binary Tree (cousins-in-binary-tree)
// Submission ID: 1659283620
// Language: java
// Timestamp (UTC): 2025-06-10T04:05:12Z

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
    static HashMap<Integer,Integer>map;
  
    public static int getHeight(TreeNode root, int target){
        
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
         int height = 0;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode rem = q.poll();
                if(rem.val == target)return height;
                
                if(rem.left!=null)q.add(rem.left);
                if(rem.right!=null)q.add(rem.right);
            }
            height++;
        }
        
        return -1;
    }
    
    public static void parent(TreeNode root){
        if(root == null)return;
        
        if(root.left!=null)map.put(root.left.val,root.val);
        if(root.right!=null)map.put(root.right.val,root.val);
        
        parent(root.left);
        parent(root.right);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        map = new HashMap<>();
        parent(root);
        
        int lx = getHeight(root,x);
        int ly = getHeight(root,y);
        System.out.println(lx+" "+ly);
        
        if(lx!=ly)return false;
        
        return map.get(x)!=map.get(y);
    }
}