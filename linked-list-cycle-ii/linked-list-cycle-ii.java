// LeetCode: Linked List Cycle II (linked-list-cycle-ii)
// Submission ID: 1654991563
// Language: java
// Timestamp (UTC): 2025-06-05T17:59:30Z

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
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode>set = new HashSet<>();
        
    
        
        ListNode temp = head;
        
        while(temp!=null){
            if(set.contains(temp))return temp;
            set.add(temp);
            temp = temp.next;
        }
        
        return null;
    }
}