// LeetCode: Insertion Sort List (insertion-sort-list)
// Submission ID: 1536721716
// Language: java
// Timestamp (UTC): 2025-02-09T07:32:30Z

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
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null) return head;

        ArrayList<Integer> elements = new ArrayList<>();

        ListNode temp = head;

        while(temp!=null){
            elements.add(temp.val);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        Collections.sort(elements);

        for(int i : elements){
            ListNode currentNode = new ListNode(i);
            tail.next = currentNode;
            tail = currentNode;
        }

        return dummy.next;
    }
}