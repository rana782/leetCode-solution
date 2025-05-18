// LeetCode: Binary Search Tree Iterator (binary-search-tree-iterator)
// Submission ID: 1637360251
// Language: java
// Timestamp (UTC): 2025-05-18T14:23:59Z

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
class BSTIterator {
    static Queue<Integer>q;
    public static void inOrder(TreeNode root){
        if(root == null)return;
        inOrder(root.left);
        q.add(root.val);
        inOrder(root.right);
    }

    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        inOrder(root);
    }
    
    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return q.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */