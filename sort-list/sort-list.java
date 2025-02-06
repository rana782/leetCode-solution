// LeetCode: Sort List (sort-list)
// Submission ID: 1533304692
// Language: java
// Timestamp (UTC): 2025-02-06T07:30:08Z

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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> elements = new ArrayList<>();

        ListNode temp = head;

        while(temp!=null){
            elements.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(elements);

        ListNode outputHead = null;
        
ListNode tail = new ListNode();
        for(int nums : elements){
            if(outputHead == null){
                outputHead = new ListNode(nums);
                tail = outputHead;
            }

            else{
                ListNode currentNode = new ListNode(nums);
                tail.next = currentNode;
                tail = currentNode;
            }


        }

        return outputHead;
    }
}