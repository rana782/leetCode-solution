// LeetCode: Even Odd Tree (even-odd-tree)
// Submission ID: 1542082038
// Language: java
// Timestamp (UTC): 2025-02-13T18:07:35Z

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
    public static boolean evenIdx(ArrayList<Integer>lists){

        for(int i = 0; i<lists.size(); i++){

            if(lists.get(i)%2 == 0) return false;

            if(i-1>=0 && lists.get(i-1)>=lists.get(i)) return false;
        }

        return true;
    }


       public static boolean oddIdx(ArrayList<Integer>lists){

        for(int i = 0; i<lists.size(); i++){

            if(lists.get(i)%2 == 1) return false;

            if(i-1>=0 && lists.get(i-1)<=lists.get(i)) return false;
        }

        return true;
    }


    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int count = 0;

        while(q.size()!=0){
            int size = q.size();
            ArrayList<Integer> subAns = new ArrayList<>();
            while(size--!=0){
                TreeNode rem = q.poll();
                 subAns.add(rem.val);

                 if(rem.left!=null){
                    q.add(rem.left);
                 }

                 if(rem.right!=null){
                    q.add(rem.right);
                 }
            }

            if(count%2 == 0){
            boolean output = evenIdx(subAns);
            if(!output)return false;
            }

            else{
                boolean output = oddIdx(subAns);
            if(!output)return false;
            }
            count++;
        }

        return true;
    }
}