// LeetCode: Balance a Binary Search Tree (balance-a-binary-search-tree)
// Submission ID: 1542884192
// Language: java
// Timestamp (UTC): 2025-02-14T12:35:36Z

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
    public static void traverse(TreeNode root, ArrayList<Integer>list){
        if(root == null) return;

        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }

    public static TreeNode getBst(Integer arr[],  int si, int ei){
        if(si>ei) return null;

        int mid = (si+ei)/2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = getBst(arr,si,mid-1);
        root.right = getBst(arr,mid+1,ei);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root.left == null && root.right == null) return root;

        ArrayList<Integer> list = new ArrayList<>();

        traverse(root,list);

        Collections.sort(list);
       
        Integer arr[] = list.toArray(new Integer[0]);
        

        int ei = arr.length-1;

        return getBst(arr,0,ei);


    }
}