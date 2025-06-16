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
    public int lenLL(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head=head.next;
        }

        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = lenLL(head);
        int groups = length/k;
        ListNode currHead = head;
        ListNode prevHead = null;
        ListNode ansNode = null;

        for(int i = 0; i < groups; i++){
            ListNode prev = null;
            ListNode curr = currHead;
            ListNode nextnode = null;
            for(int j = 0; j < k; j++){
                nextnode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextnode;
            }
            if(prevHead == null){
                ansNode = prev;
            }
            else {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }

        prevHead.next = currHead;

        return ansNode;
        
    }
}