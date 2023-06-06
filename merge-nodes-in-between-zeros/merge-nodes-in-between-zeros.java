// LeetCode: Merge Nodes in Between Zeros (merge-nodes-in-between-zeros)
// Submission ID: 965064475
// Language: java
// Timestamp (UTC): 2023-06-06T10:10:02Z

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
    public ListNode mergeNodes(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
     ListNode find = new ListNode(0);
     
     ListNode tail = find; 
     ListNode temp = head;
     
     while(temp!=null){
         int sum = 0;
         while(temp.val!=0){
           sum+=temp.val;
           temp = temp.next;
         }
         temp = temp.next;
         ListNode store = new ListNode(sum);
         tail.next = store;
         tail = store;
     }
     
     System.gc();
     return find.next.next;
    }
}