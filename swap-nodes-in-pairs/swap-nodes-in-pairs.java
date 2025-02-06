// LeetCode: Swap Nodes in Pairs (swap-nodes-in-pairs)
// Submission ID: 1533292215
// Language: java
// Timestamp (UTC): 2025-02-06T07:16:06Z

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
     public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode revHead = null;

        ListNode temp = head;

        while(temp!=null){
            if(revHead == null){
                revHead = new ListNode(temp.val);
            }

            else{
                ListNode currNode = new ListNode(temp.val);
                currNode.next = revHead;
                revHead = currNode;
            }

            temp = temp.next;
        }

        return revHead;
    }
    public static int getLength(ListNode head){
        if(head == null) return 0;

        if(head.next == null) return 1;

        int count = 0;

        ListNode temp = head;

        while(temp!=null){
            count++;
            temp = temp.next;
        }

        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null) return head;



int length = getLength(head);

int left = 1;
int right = k;
ListNode outputHead = head;
while(right<=length){
 
 outputHead = reverseBetween(outputHead,left,right);
 left+=k;
 right+=k;
     
}

return outputHead;
        
    }








    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

         ListNode dummy = new ListNode(-1);
         dummy.next = head;

         ListNode rear = dummy;
          ListNode front = dummy;



          for(int i = 1; i<left; i++){
            rear = rear.next;
          }

          ListNode rfr1 = rear;

          rear = rear.next;


          for(int i = 0; i<right; i++){
            front = front.next;
          }


          ListNode rfr2 = front.next;

          front.next = null;


          ListNode revHead = reverse(rear);

          rfr1.next = revHead;

          ListNode temp = revHead;

          while(temp.next!=null){
            temp = temp.next;
          }

          temp.next = rfr2;
          return dummy.next;
    }
    public ListNode swapPairs(ListNode head) {
        if(head ==  null || head.next == null) return head;

        ListNode outputHead = reverseKGroup(head,2);

        return outputHead;
       
    }
}