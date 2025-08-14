// LeetCode: Merge k Sorted Lists (merge-k-sorted-lists)
// Submission ID: 1735288133
// Language: java
// Timestamp (UTC): 2025-08-14T18:32:05Z

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
    public static class Pair implements Comparable<Pair>{
        ListNode node;
        int val;

        Pair(ListNode node, int val){
            this.node = node;
            this.val = val;
        }

        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for(ListNode head : lists){
        if(head!=null){
             Pair p = new Pair(head,head.val);
            pq.add(p);
        }
        }

        while(!pq.isEmpty()){
           Pair rem = pq.poll();
           tail.next = rem.node;
           tail = tail.next;
           if(rem.node.next!=null){
            pq.add(new Pair(rem.node.next,rem.node.next.val));
           }
        }

        return dummy.next;
    }
}