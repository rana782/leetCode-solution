// LeetCode: Lowest Common Ancestor of a Binary Tree III (lowest-common-ancestor-of-a-binary-tree-iii)
// Submission ID: 1657993960
// Language: java
// Timestamp (UTC): 2025-06-08T19:52:05Z

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public static List<Node> getPath(Node root, int target,List<Node>subAns){
        if(root == null)return new ArrayList<>();
        subAns.add(root);
        
        if(root.val == target){
            return new ArrayList<>(subAns);
        }
        
     List<Node>l1 = getPath(root.left,target,subAns);
        
        if(!l1.isEmpty())return l1;
        
        List<Node>l2 = getPath(root.right,target,subAns);
        
        if(!l2.isEmpty())return l2;
        
        subAns.remove(subAns.size()-1);
        
        return new ArrayList<>();
        
     
        
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        Node temp = p;
    
        
        while(temp.parent!=null){
            temp = temp.parent;
        }
        
       Node root = temp;
        
        List<Node>subAns = new ArrayList<>();
        
        List<Node>l1 = getPath(root,p.val,subAns);
        subAns = new ArrayList<>();
        
        List<Node>l2 = getPath(root,q.val,subAns);
        
        Node output = root;
        
        int idx1 = 0;
        int idx2 = 0;
        
        while(idx1<l1.size() && idx2<l2.size()){
            if(l1.get(idx1).val!=l2.get(idx2).val)return output;
            output = l1.get(idx1);
            idx1++;
            idx2++;
        }
        
        return output;
    }
}