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
        List<Integer> listIntegers = new ArrayList<>();
        for(ListNode list: lists){
            ListNode listNumber = list;
            while(listNumber!=null){
                listIntegers.add(listNumber.val);
                listNumber = listNumber.next;
            }            
        }

        Collections.sort(listIntegers);

        ListNode ans = new ListNode(0);
         ListNode finalAns = ans;
        for(int element : listIntegers){
            ans.next = new ListNode(element);
            ans = ans.next;
        }

        return finalAns.next;
    }
}