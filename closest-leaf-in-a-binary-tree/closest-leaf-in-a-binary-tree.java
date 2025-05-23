// LeetCode: Closest Leaf in a Binary Tree (closest-leaf-in-a-binary-tree)
// Submission ID: 1642213071
// Language: java
// Timestamp (UTC): 2025-05-23T14:32:13Z

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
    public static TreeNode findNode(TreeNode root, int k){
        if(root == null)return null;

        if(root.val == k)return root;

        TreeNode left = findNode(root.left,k);
        if(left!=null)return left;

        return findNode(root.right, k);
    }
    public static void dfs(TreeNode root, HashMap<Integer,List<TreeNode>>map){
        if(root == null)return;

        if(root.left!=null){
                List<TreeNode>subAns = map.getOrDefault(root.val,new ArrayList<>());
                subAns.add(root.left);
                map.put(root.val,subAns);

                List<TreeNode>subAns1 = map.getOrDefault(root.left.val,new ArrayList<>());
                subAns1.add(root);
                map.put(root.left.val,subAns1);
        }

               if(root.right!=null){
                List<TreeNode>subAns = map.getOrDefault(root.val,new ArrayList<>());
                subAns.add(root.right);
                map.put(root.val,subAns);

                List<TreeNode>subAns1 = map.getOrDefault(root.right.val,new ArrayList<>());
                subAns1.add(root);
                map.put(root.right.val,subAns1);
        }
        dfs(root.left,map);
        dfs(root.right,map);

    }
    public int findClosestLeaf(TreeNode root, int k) {
       if(root.left == null && root.right == null)return 1;

       HashMap<Integer,List<TreeNode>>map = new HashMap<>();
       dfs(root,map);

       Queue<TreeNode>q = new LinkedList<>();

       TreeNode nodeK = findNode(root,k);
       q.add(nodeK);
       int level = 0;
       HashSet<Integer>visited = new HashSet<>();

       while(q.size()!=0){
        TreeNode rem = q.poll();
        if(rem.left == null && rem.right == null)return rem.val;

            visited.add(rem.val);

            for(TreeNode node : map.get(rem.val)){
                if(!visited.contains(node.val)){
                    q.add(node);
                }
            }
        
        
       }

       return -1;
    }
}