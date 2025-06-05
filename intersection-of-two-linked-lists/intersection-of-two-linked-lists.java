// LeetCode: Intersection of Two Linked Lists (intersection-of-two-linked-lists)
// Submission ID: 1655067874
// Language: java
// Timestamp (UTC): 2025-06-05T19:30:53Z

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode>set = new HashSet<>();
        
        ListNode tempA = headA;
        
        while(tempA!=null){
            set.add(tempA);
            tempA = tempA.next;
        }
        
        
        ListNode tempB = headB;
        
        while(tempB!=null){
            if(set.contains(tempB))return tempB;
            tempB = tempB.next;
        }
        
        return null;
    }
}