// LeetCode: Maximum Twin Sum of a Linked List (maximum-twin-sum-of-a-linked-list)
// Submission ID: 965206286
// Language: java
// Timestamp (UTC): 2023-06-06T14:22:29Z

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
    public int pairSum(ListNode head) {
        if(head == null){
            return 0;
        }
    ListNode revHead =  new ListNode(head.val);
    ListNode temp = head, temp1 = head;
    temp = temp.next;
    while(temp!=null){
       
        ListNode store = new ListNode(temp.val);
        store.next = revHead;
        revHead = store;
        temp = temp.next;
    }
int max = Integer.MIN_VALUE;
int sum =0;
while(revHead!=null){
    sum = revHead.val+temp1.val;
    if(sum>=max){
        max = sum;
    }
    revHead = revHead.next;
    temp1 = temp1.next;
}
   return max;     
    }
}