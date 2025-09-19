class Solution {
    private int moves = 0;

    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1; 
    }

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }
}