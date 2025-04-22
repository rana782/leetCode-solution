// LeetCode: Plus One Linked List (plus-one-linked-list)
// Submission ID: 1614851284
// Language: java
// Timestamp (UTC): 2025-04-22T17:22:37Z

class Solution {
    public ListNode plusOne(ListNode head) {
        // Step 1: Convert linked list to string
        StringBuilder str = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            str.append(temp.val);
            temp = temp.next;
        }

        // Step 2: Add one to the string number (manual addition)
        StringBuilder result = new StringBuilder();
        int carry = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            int digit = str.charAt(i) - '0';
            int sum = digit + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) result.append(carry);
        result.reverse();

        // Step 3: Build linked list from result
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < result.length(); i++) {
            curr.next = new ListNode(result.charAt(i) - '0');
            curr = curr.next;
        }

        return dummy.next;
    }
}
