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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int lowest_ind = 0;
        
        for (int i = 1; i < lists.length; i++) {
            if (lists[i] != null && lists[lowest_ind] != null && lists[lowest_ind].val > lists[i].val
            || lists[i] != null && lists[lowest_ind] == null) {
                lowest_ind = i;
            } 
        }
        
        if (lists[lowest_ind] == null) {
            return null;
        }
        int next_val = lists[lowest_ind].val;
        lists[lowest_ind] = lists[lowest_ind].next;

        
        return new ListNode(next_val, mergeKLists(lists));
        
    }
}
