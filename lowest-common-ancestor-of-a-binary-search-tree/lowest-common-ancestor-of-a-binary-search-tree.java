// LeetCode: Lowest Common Ancestor of a Binary Search Tree (lowest-common-ancestor-of-a-binary-search-tree)
// Submission ID: 1655375030
// Language: java
// Timestamp (UTC): 2025-06-06T05:58:20Z

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public static List<TreeNode> solution(TreeNode root,int target,List<TreeNode>subAns){
        if(root ==null){
            return new ArrayList<>();
        }
        
        subAns.add(root);
        
        if(root.val == target){
            return new ArrayList<>(subAns);
        }
        
        List<TreeNode>left = solution(root.left,target,subAns);
        List<TreeNode>right = solution(root.right,target,subAns);
        
        subAns.remove(subAns.size()-1);
        
        return left.size()!=0 ? left : right;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>subAns = new ArrayList<>();
        List<TreeNode>p1 = solution(root,p.val,subAns);
        
        subAns = new ArrayList<>();
        
        List<TreeNode>p2 = solution(root,q.val,subAns);
        
        System.out.println(p1);
        System.out.println(p2);
        
        int itr1 = 0;
        int itr2 = 0;
        
        while(itr1!=p1.size() && itr2!=p2.size()){
            if(p1.get(itr1).val != p2.get(itr2).val){
                return p1.get(itr1-1);
            }
            itr1++;
            itr2++;
        }
        
        
        
        return itr1 == p1.size() ? p1.get(itr1-1) : p2.get(itr2-1);
        
    }
}