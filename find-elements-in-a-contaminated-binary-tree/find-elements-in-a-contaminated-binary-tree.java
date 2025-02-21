// LeetCode: Find Elements in a Contaminated Binary Tree (find-elements-in-a-contaminated-binary-tree)
// Submission ID: 1551197250
// Language: java
// Timestamp (UTC): 2025-02-21T23:23:44Z

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
class FindElements {
  static  HashSet<Integer> set;
    public static void buildTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size()!=0){
            TreeNode rem = q.poll();
            set.add(rem.val);

            if(rem.left!=null){
                rem.left.val = 2*rem.val+1;
                q.add(rem.left);
            }

            if(rem.right!=null){
                rem.right.val = 2*rem.val+2;
                q.add(rem.right);
            }
        }
        
    }
    public FindElements(TreeNode root) {
        if(root!=null && root.val == -1)root.val = 0;
        set = new HashSet<>();

        buildTree(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */