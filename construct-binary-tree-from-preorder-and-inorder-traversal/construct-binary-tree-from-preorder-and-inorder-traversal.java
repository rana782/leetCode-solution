// LeetCode: Construct Binary Tree from Preorder and Inorder Traversal (construct-binary-tree-from-preorder-and-inorder-traversal)
// Submission ID: 1542812107
// Language: java
// Timestamp (UTC): 2025-02-14T10:45:29Z

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
    public static TreeNode solution(int pre[], int[] in,int psi, int pei, int isi, int iei){
        if(isi>iei) return null;

        int idx = isi;

        while(in[idx]!=pre[psi])idx++;

        int length = idx-isi;

        TreeNode root = new TreeNode(pre[psi]);

        root.left = solution(pre,in, psi+1,psi+length,isi,idx-1);
        root.right = solution(pre,in,psi+length+1,pei,idx+1,iei);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pei = preorder.length-1;
        int iei = inorder.length-1;
         TreeNode output = solution(preorder,inorder,0,pei,0,iei);
         return output;
    }
}