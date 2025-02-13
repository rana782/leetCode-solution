// LeetCode: Symmetric Tree (symmetric-tree)
// Submission ID: 1541757618
// Language: java
// Timestamp (UTC): 2025-02-13T13:23:18Z

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
   

    public static void getList1(TreeNode root ,ArrayList<Integer> output){
        if(root == null){
            output.add(101);
            return;
        }
        output.add(root.val);
        getList1(root.left,output);
        getList1(root.right,output);
    }

     public static void getList2(TreeNode root, ArrayList<Integer> output){
        if(root == null){
            output.add(101);
            return;
        }
        output.add(root.val);
        getList2(root.right,output);
        getList2(root.left,output);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;

        ArrayList<Integer> output1 = new ArrayList<>();
        getList1(root.left,output1);

        ArrayList<Integer> output2 = new ArrayList<>();
        getList2(root.right,output2);


        if(output1.size()!=output2.size()) return false;

        for(int i = 0; i<output1.size(); i++){
            if(output1.get(i)!=output2.get(i)) return false;
        }

        return true;
    }
}