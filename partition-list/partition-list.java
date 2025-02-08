// LeetCode: Partition List (partition-list)
// Submission ID: 1536180181
// Language: java
// Timestamp (UTC): 2025-02-08T19:58:19Z

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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
         ListNode dummy = new ListNode(-1);
         ListNode tail = dummy;

         ListNode temp = head;

         while(temp!= null){
            if(temp.val<x){
                ListNode currentNode = new ListNode(temp.val);
                tail.next = currentNode;
                tail = currentNode;
            }

            temp = temp.next;
         }

         temp = head;

         while(temp!=null){
            if(temp.val>=x){
                 ListNode currentNode = new ListNode(temp.val);
                tail.next = currentNode;
                tail = currentNode;
            }
            temp = temp.next;
         }

         return dummy.next;
    }
}