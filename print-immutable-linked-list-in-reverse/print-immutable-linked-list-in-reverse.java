// LeetCode: Print Immutable Linked List in Reverse (print-immutable-linked-list-in-reverse)
// Submission ID: 1663425261
// Language: java
// Timestamp (UTC): 2025-06-14T02:31:21Z

/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode>st = new Stack<>();
        
        ImmutableListNode temp = head;
        
        while(temp!=null){
            st.push(temp);
            temp = temp.getNext();
        }
        
        
        while(!st.isEmpty()){
            st.pop().printValue();
        }
            
    }
}