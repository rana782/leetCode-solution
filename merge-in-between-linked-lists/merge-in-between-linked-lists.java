// LeetCode: Merge In Between Linked Lists (merge-in-between-linked-lists)
// Submission ID: 966490578
// Language: java
// Timestamp (UTC): 2023-06-08T08:48:29Z

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode find = new ListNode(0);
        ListNode tail = find, temp = list1;
        int length= 0;
        while(temp!=null){
            if(length==a){
                while(list2!=null){
                   
                    tail.next = list2;
                    tail = tail.next;
                    list2 = list2.next;
                }
                while(length!=b+1){
                    length++;
                    temp = temp.next;
                }
            }
        
              
                tail.next = temp;
                tail = tail.next;
                length++;
                temp =temp.next;
            }
            return find.next;
        }
        
   
    
}