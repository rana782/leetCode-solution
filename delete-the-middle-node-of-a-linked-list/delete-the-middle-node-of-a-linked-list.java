// LeetCode: Delete the Middle Node of a Linked List (delete-the-middle-node-of-a-linked-list)
// Submission ID: 1532385537
// Language: java
// Timestamp (UTC): 2025-02-05T14:00:39Z

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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode rear = dummy;
        ListNode slow = head;
        ListNode fast = head;


        while(fast.next!=null && fast.next.next!=null){
            rear = rear.next;
            slow = slow.next;
            fast = fast.next.next;
        }


        if(fast.next == null){
            rear.next = slow.next;
        }

        else{
            slow = slow.next;
            rear = rear.next;

            rear.next = slow.next;
        }

        return head;

    }
}