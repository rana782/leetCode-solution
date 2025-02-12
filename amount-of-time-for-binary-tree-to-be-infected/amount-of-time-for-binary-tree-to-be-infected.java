// LeetCode: Amount of Time for Binary Tree to Be Infected (amount-of-time-for-binary-tree-to-be-infected)
// Submission ID: 1540819110
// Language: java
// Timestamp (UTC): 2025-02-12T18:05:55Z

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
    public static void getRel(TreeNode root,HashMap<TreeNode,TreeNode>map){
        if(root == null) return;

        if(root.left!=null){
            map.put(root.left,root);
        }

        if(root.right!=null){
            map.put(root.right,root);
        }

        getRel(root.left,map);
        getRel(root.right,map);
    }

    public static TreeNode getNode(TreeNode root, int start){
        if(root == null) return root;

        if(root.val == start) return root;

        TreeNode ls = getNode(root.left,start);
        TreeNode rs = getNode(root.right,start);

        return ls!=null ? ls : rs;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        getRel(root,map);

        TreeNode firstNode = getNode(root,start);
        Queue<TreeNode> q = new LinkedList<>();
        int time = 0;

        q.add(firstNode);
        visited.add(firstNode);

        while(q.size()!=0){
            int size = q.size();

            while(size--!=0){
                TreeNode rem = q.poll();

                if(rem.left!=null && !visited.contains(rem.left)){
                    q.add(rem.left);
                    visited.add(rem.left);
                }

                if(rem.right!=null && !visited.contains(rem.right)){
                    q.add(rem.right);
                    visited.add(rem.right);
                }

                if(map.containsKey(rem) && !visited.contains(map.get(rem))){
                    q.add(map.get(rem));
                    visited.add(map.get(rem));
                }
            }
            time+=1;
        }

        return time == 0 ? 0 : time-1;

    }

    
}