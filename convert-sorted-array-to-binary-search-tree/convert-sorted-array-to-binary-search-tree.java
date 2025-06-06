// LeetCode: Convert Sorted Array to Binary Search Tree (convert-sorted-array-to-binary-search-tree)
// Submission ID: 1655691478
// Language: java
// Timestamp (UTC): 2025-06-06T13:15:14Z

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
    public static TreeNode solution(int nums[], int si, int ei){
        if(si>ei)return null;
        
        int mid = si+(ei-si)/2;
        
        TreeNode currNode = new TreeNode(nums[mid]);
        currNode.left = solution(nums,si,mid-1);
        currNode.right = solution(nums,mid+1,ei);
        
        return currNode;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        
        
        return solution(nums,0,nums.length-1);
    }
}