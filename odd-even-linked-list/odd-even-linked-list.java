// LeetCode: Odd Even Linked List (odd-even-linked-list)
// Submission ID: 1655010986
// Language: java
// Timestamp (UTC): 2025-06-05T18:19:39Z

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return head;
        
        ListNode dummyEven = new ListNode(-1);
        ListNode tailEven = dummyEven;
        
         ListNode dummyOdd = new ListNode(-1);
        ListNode tailOdd = dummyOdd;
        
        ListNode temp = head;
        
        int count = 1;
        
        while(temp!=null){
            if(count%2 == 0){
                ListNode currNode = new ListNode(temp.val);
                tailEven.next = currNode;
                tailEven = tailEven.next;
            }
            else{
                ListNode currNode = new ListNode(temp.val);
                tailOdd.next = currNode;
                tailOdd = tailOdd.next;
            }
            temp =temp.next;
            count++;
        }
        
        
        tailOdd.next = dummyEven.next;
        
        return dummyOdd.next;
       
        
        
        
      
        
        
     
       
        
    }
}