// LeetCode: Smallest Subtree with all the Deepest Nodes (smallest-subtree-with-all-the-deepest-nodes)
// Submission ID: 1659063694
// Language: java
// Timestamp (UTC): 2025-06-09T20:37:47Z

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
    
    public static List<TreeNode> getPath(TreeNode root, int target,List<TreeNode>subAns){
        if(root == null)return new ArrayList<>();
        
        subAns.add(root);
        
        if(root.val == target)return new ArrayList<>(subAns);
        
        List<TreeNode>ls = getPath(root.left,target,subAns);
        if(!ls.isEmpty())return ls;
        
        List<TreeNode>rs = getPath(root.right,target,subAns);
        if(!rs.isEmpty())return rs;
        
        subAns.remove(subAns.size()-1);
        
        return new ArrayList<>();
    }

    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        HashMap<Integer,List<TreeNode>>map = new HashMap<>();
        
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        
        int level =0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            List<TreeNode>l = new ArrayList<>();
            
            while(size-->0){
                TreeNode rem = q.poll();
                l.add(rem);
                if(rem.left!=null)q.add(rem.left);
                if(rem.right!=null)q.add(rem.right);
               
            }
            map.put(level,l);
            level++;
        }
        
        
        List<TreeNode>getNodes = map.get(level-1);
        
        int t1 = getNodes.get(0).val;
        int t2 = getNodes.get(getNodes.size()-1).val;
        
        List<TreeNode>subAns = new ArrayList<>();
        
        List<TreeNode>p1 = getPath(root,t1,subAns);
        
        subAns = new ArrayList<>();
        List<TreeNode>p2 = getPath(root,t2,subAns);
        
        TreeNode output = null;
        
        int idx1 = 0;
        int idx2 = 0;
        
        while(idx1<p1.size() && idx2<p2.size()){
            if(p1.get(idx1).val!=p2.get(idx2).val)return output;
            
            output = p1.get(idx1);
            idx1++;
            idx2++;
        }
      
        
         
        
        return output;
    }
}