// LeetCode: Inorder Successor in BST II (inorder-successor-in-bst-ii)
// Submission ID: 1636692143
// Language: java
// Timestamp (UTC): 2025-05-17T19:38:21Z

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
    public static Node findRoot(Node node){
        
        while(node.parent!=null){
          node = node.parent;
        }

        return node;
    }
    public Node inorderSuccessor(Node node) {
        Node p = node;
        Node output = null;
        Node root = findRoot(node);

        while(root!=null){
            if(p.val>=root.val){
                root = root.right;
            }
            else{
                output = root;
                root = root.left;
            }
        }

        return output;
    }
}