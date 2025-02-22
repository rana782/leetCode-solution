// LeetCode: Split Linked List in Parts (split-linked-list-in-parts)
// Submission ID: 1551249912
// Language: java
// Timestamp (UTC): 2025-02-22T01:35:24Z

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
    public static int getHeight(ListNode head, int currHeight){
        ListNode temp = head;

        while(temp!=null){
            currHeight++;
            temp = temp.next;
        }

        return currHeight;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode output[] = new ListNode[k];
        if(head == null) return output;

        if(head.next == null){
            output[0] = head;
            return output;
        }

        int height =  getHeight(head,0);

        int equalDistribution = height/k;

        int size[] = new int[k];

        for(int i = 0; i<k; i++){
            size[i] = equalDistribution;
            output[0] = new ListNode();
        }
        

        int extra = height%k;
   int idx = 0;
        while(extra!=0){
          size[idx++]+=1;
          extra--;
        }

    ListNode temp = head;

    for(int i = 0; i<k; i++){
        output[i] = temp;
         if(size[i] == 0) break;
        int nextMove = size[i];

       temp = getPtr(temp,nextMove);
    }

    return output;
    }

    public static ListNode getPtr(ListNode temp,int nextMove){
        if(temp == null) return temp;
        while(temp!=null && nextMove!=1){
            nextMove--;
            temp = temp.next;
        }
        ListNode output = temp.next;
        temp.next = null;
        return output;
    }
}