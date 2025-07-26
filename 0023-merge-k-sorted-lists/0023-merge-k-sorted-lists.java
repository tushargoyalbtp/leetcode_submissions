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
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < lists.length; i++){
            ListNode list = lists[i];

            while(list!=null){
                pq.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            tail.next = new ListNode(pq.poll());
            tail = tail.next;
        }

        return dummy.next;

        // while (lists.length > 1) {
        //     List<ListNode> mergedLists = new ArrayList<>();
        //     for (int i = 0; i < lists.length; i += 2) {
        //         ListNode list1 = lists[i];
        //         ListNode list2 = (i + 1 < lists.length) ? lists[i + 1] : null;
        //         mergedLists.add(mergeTwoLists(list1, list2));
        //     }
        //     lists = mergedLists.toArray(new ListNode[mergedLists.size()]);
        // }



        // return lists[0];
    }

    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     if (list1 == null) {
    //         return list2;
    //     } else if (list2 == null) {
    //         return list1;
    //     } else if (list1.val < list2.val) {
    //         list1.next = mergeTwoLists(list1.next, list2);
    //         return list1;
    //     } else {
    //         list2.next = mergeTwoLists(list1, list2.next);
    //         return list2;
    //     }
    // }
}