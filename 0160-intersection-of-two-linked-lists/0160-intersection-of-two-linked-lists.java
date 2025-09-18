/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tail1=headA;
        ListNode tail2=headB;
        while(tail1!=tail2){
            if(tail1==null){
                tail1=headB;
            }
            else{
                tail1=tail1.next;
            }
            if(tail2==null){
                tail2=headA;
            }
            else{
                tail2=tail2.next;
            }
        }

        return tail1;
    }
}