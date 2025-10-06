class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Count the length
        ListNode curr = head;
        int count = 1;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Step 2: Connect tail to head (circular list)
        curr.next = head;

        // Step 3: Normalize k
        k = k % count;
        int stepsToNewHead = count - k;

        // Step 4: Move to the new tail
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}