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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        int len = 0;
        ListNode seer = head;
        while(seer != null) {
            seer = seer.next;
            len++;
        }

        ListNode pointer = head.next;
        ListNode prev = head;
        for (int i = 0; i < Math.abs(len - n%len) -1; i++) {
            if (pointer.next != null && prev.next != null) {
                pointer = pointer.next;
                prev = prev.next;
            } else if (pointer.next == null) {
                pointer = head;
                prev = prev.next;
            } else {
                pointer = pointer.next;
                prev = head;
            }
        }

        if (prev.next == null) {
            head = pointer.next;
        }

        if (prev.next != null) {
            prev.next = pointer.next;
        }

        return head;

        
    }
}
