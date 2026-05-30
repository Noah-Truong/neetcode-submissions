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
    public void reorderList(ListNode head) {
        if (head != null) {
            ListNode start = head;
            ListNode end = head;
            ListNode secondLast = head;
            while (end.next != null) {
                if (end.next.next == null) {
                    secondLast = end;
                }
                end = end.next;
            }
            secondLast.next = null;
            ListNode recurs = start.next;
            start.next = end;
            end.next = recurs;
            reorderList(recurs);
        }
    }
}
