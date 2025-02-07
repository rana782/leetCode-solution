// LeetCode: Linked List Cycle (linked-list-cycle)
// Submission ID: 1534693399
// Language: java
// Timestamp (UTC): 2025-02-07T11:58:34Z

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next ==  null) return false;
        ListNode fast = head;
        ListNode slow =  head;


        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }

        return false;
    }
}