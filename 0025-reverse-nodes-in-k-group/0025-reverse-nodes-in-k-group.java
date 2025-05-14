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

    public ListNode getKthNode(ListNode temp, int k){
        k -= 1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = head;

        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }

                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head){
                head = kthNode;
            }
            else{
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
        
    }

    public void reverseLL(ListNode head){
        ListNode curr = head;
        ListNode forw = null;
        ListNode prev = null;

        while(curr!=null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        head = prev;
        
    }
}