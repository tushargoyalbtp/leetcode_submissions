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
        int count = 0;

        ListNode temp = head;

        // Count length

        while (temp != null) {

            count++;

            temp = temp.next;

        }

        int pivot = count - n;

        if (pivot == 0) {

            return head.next;

        }
        
        temp = head;

        for (int i = 1; i < pivot; i++) {

            temp = temp.next;

        }

        // Delete node

        temp.next = temp.next.next;



        return head;
    }
}