// LeetCode: Remove Linked List Elements (remove-linked-list-elements)
// Submission ID: 1531232468
// Language: java
// Timestamp (UTC): 2025-02-04T16:14:33Z

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
    public ListNode removeElements(ListNode head, int val) {
        if(head ==  null) return head;

        ListNode rear = head;
        ListNode front = head.next;

        while(front!=null){
            if(front.val == val){
                ListNode ptr = front.next;
                rear.next = front.next;
                front = ptr;
            }
            else{
                
                rear = rear.next;
                front = front.next;
            }
        }

        if(head.val == val) head = head.next;


        return head;
    }
}