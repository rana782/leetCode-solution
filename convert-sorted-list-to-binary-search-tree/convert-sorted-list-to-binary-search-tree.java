// LeetCode: Convert Sorted List to Binary Search Tree (convert-sorted-list-to-binary-search-tree)
// Submission ID: 1542866451
// Language: java
// Timestamp (UTC): 2025-02-14T12:08:13Z

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public static TreeNode solution(Integer arr[], int si, int ei){
        if(si>ei) return null;

        int mid = (si+ei)/2;

        TreeNode root = new TreeNode(arr[mid]);

        root.left = solution(arr,si,mid-1);
        root.right = solution(arr,mid+1,ei);

        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            TreeNode output = new TreeNode(head.val);
            return output;
        }

        ListNode temp = head;
        ArrayList<Integer> lists = new ArrayList<>();
        while(temp!=null){
            lists.add(temp.val);
            temp = temp.next;
        }

        Integer arr[] = lists.toArray(new Integer[0]);

        int ei = arr.length-1;

        return solution(arr,0,ei);
    }
}