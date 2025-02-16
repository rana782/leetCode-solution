// LeetCode: Delete Node in a BST (delete-node-in-a-bst)
// Submission ID: 1545111523
// Language: java
// Timestamp (UTC): 2025-02-16T13:30:16Z

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
    public static boolean find(TreeNode root, int key){
        if(root == null) return false;

        if(root.val == key) return true;

        if(key<root.val){
            return find(root.left,key);
        }

        else if(key>root.val){
            return find(root.right,key);
        }
        else{

        }

        return false;
    }


public static int max(TreeNode root){
    
    if(root.right!=null) return max(root.right);

    else{
        return root.val;
    }
    
}
  public static TreeNode remove(TreeNode root, int key){
    if(root == null) return null;

    if(root.val == key){

        if(root.left!=null){
      int leftMax = max(root.left);
       root.val = leftMax;
       root.left = remove(root.left,leftMax);
       return root;
        }

        else{
            return root.right;
        }
      
    }

    else if(key>root.val){
      root.right = remove(root.right,key);
    }

    else if(key<root.val){
   root.left = remove(root.left,key);
    }
    else{

    }

    return root;
  }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(!find(root,key)) return root;

        return remove(root,key);
    }
}