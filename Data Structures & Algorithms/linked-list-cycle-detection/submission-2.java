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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        
        while (pointer2 != null && pointer1 != pointer2) {
            pointer2 = pointer2.next;
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            }
            pointer1 = pointer1.next;
        }    

        return pointer1 == pointer2;

        
    }
}
