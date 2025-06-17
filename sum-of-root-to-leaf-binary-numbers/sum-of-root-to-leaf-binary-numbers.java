// LeetCode: Sum of Root To Leaf Binary Numbers (sum-of-root-to-leaf-binary-numbers)
// Submission ID: 1666836758
// Language: java
// Timestamp (UTC): 2025-06-17T06:41:10Z

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
    public static int getNum(List<Integer>l){
        
        int output = 0;
        int pow = 0;
        
        for(int i  = l.size()-1; i>=0; i--){
            
           
            if(l.get(i) == 1)output+=Math.pow(2,pow);
            
            pow++;
        }
        
        return output;
    }
    
    static int sum;
    
    public static void solution(TreeNode root,List<Integer>l){
        if(root == null)return;
        
        l.add(root.val);
        if(root.left == null && root.right == null){
            System.out.println(l);
            sum+=getNum(l);
            l.remove(l.size()-1);
            return;
        }
        
        solution(root.left,l);
        solution(root.right,l);
        l.remove(l.size()-1);
        
    }
    public int sumRootToLeaf(TreeNode root) {
        
        sum = 0;
        solution(root,new ArrayList<>());
        return sum;
    }
}