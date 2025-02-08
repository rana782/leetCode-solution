// LeetCode: Rotate List (rotate-list)
// Submission ID: 1535542632
// Language: java
// Timestamp (UTC): 2025-02-08T07:28:24Z

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int length = 1;
        ListNode temp = head;

        while(temp.next!=null){
            temp = temp.next;
            length++;
        }

        temp.next = head;

        int effectiveRotation = k%length;
        int idx = length-effectiveRotation;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode rear = dummy;

        temp = head;

        while(idx!=0){
            temp = temp.next;
            rear = rear.next;
            idx--;
        }

        rear.next = null;
        return temp;




    }
}