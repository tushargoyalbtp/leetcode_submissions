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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;

        ListNode dummy = new ListNode(-1); // dummy head
        ListNode curr = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                curr.next = t1;   // link node
                t1 = t1.next;     // move pointer
            } else {
                curr.next = t2;
                t2 = t2.next;
            }
            curr = curr.next;     // move merged list pointer
        }

        // Attach remaining nodes
        if (t1 != null) curr.next = t1;
        if (t2 != null) curr.next = t2;

        return dummy.next;
    }
}