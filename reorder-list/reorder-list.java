// LeetCode: Reorder List (reorder-list)
// Submission ID: 1657952959
// Language: java
// Timestamp (UTC): 2025-06-08T18:49:46Z

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
class Solution {
    public static ListNode solution(ListNode head){
        if(head == null || head.next == null || head.next.next == null)return head;
        
        ListNode temp = head;
        ListNode tempNext = head.next;
        
        ListNode prev = head;
            ListNode curr = head.next;
        
        while(curr.next!=null){
            curr = curr.next;
            prev = prev.next;
        }
        
        temp.next = curr;
        prev.next = null;
        
        curr.next = solution(tempNext);
        
        return temp;
    }
    public void reorderList(ListNode head) {
        
        solution(head);
    }
}