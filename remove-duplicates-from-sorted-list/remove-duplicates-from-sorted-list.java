// LeetCode: Remove Duplicates from Sorted List (remove-duplicates-from-sorted-list)
// Submission ID: 1531320320
// Language: java
// Timestamp (UTC): 2025-02-04T17:21:56Z

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;


        ListNode rear = head;
        ListNode front = head.next;

        while(front!= null){
            if(front.val == rear.val){
                ListNode ptr = front.next;
                rear.next = front.next;
                front = ptr;
            }

            else{
                rear = rear.next;
                front = front.next;
            }
        }

        return head;
    }
}