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
    public boolean isPalindrome(ListNode head) {

        // ListNode newHead = reverse(head);
        ListNode curr = head;
        int count = 0;

        while(curr!=null){
            curr = curr.next;
            count++;
        }

        int[] node = new int[count];
        int i = 0;
        while(head!=null){
            node[i] = head.val;
            i++;
            head = head.next;
        }

        int k = 0;
        int j = count - 1;

        while(k<j){
            if(node[k] != node[j]){
                return false;
            }
            k++;
            j--;
        }

        return true;


        // while(curr!=null){
        //     System.out.print(curr.val + " ");
        //     curr = curr.next;
        // }

        // while(head!=null && newHead != null){
           
        //     if(newHead.val != head.val){
        //         return false;
        //     }

        //     newHead = newHead.next;
        //     head = head.next;
        // }

        // return true;

    }

    // public ListNode reverse(ListNode head){
    //     ListNode curr = head;
    //     ListNode forw = null;
    //     ListNode prev = null;

    //     while(curr!=null){
    //         forw = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = forw;
    //     }

    //     head = prev;

    //     return head;
    // }
}