// LeetCode: Find Mode in Binary Search Tree (find-mode-in-binary-search-tree)
// Submission ID: 1542947187
// Language: java
// Timestamp (UTC): 2025-02-14T14:01:06Z

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
    static int maxOccurence;
    public static void traverse(TreeNode root, HashMap<Integer,Integer>map){
        if(root == null) return;

        traverse(root.left,map);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        maxOccurence = Math.max(maxOccurence,map.get(root.val));
        traverse(root.right,map);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer>map = new HashMap<>();
        maxOccurence = 0;

        traverse(root,map);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele : map.keySet()){
            if(map.get(ele) == maxOccurence)ans.add(ele);
        }

        int output[] = new int[ans.size()];
        for(int i = 0; i<output.length; i++){
            output[i] = ans.get(i);
        }

        return output;
    }
}