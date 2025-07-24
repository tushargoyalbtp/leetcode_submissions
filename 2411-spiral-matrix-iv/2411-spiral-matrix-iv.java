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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];

        // Initialize matrix with -1
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = -1;
            }
        }

        ListNode curr = head;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (curr != null && top <= bottom && left <= right) {
            // Left to Right
            for (int j = left; j <= right && curr != null; j++) {
                ans[top][j] = curr.val;
                curr = curr.next;
            }
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom && curr != null; i++) {
                ans[i][right] = curr.val;
                curr = curr.next;
            }
            right--;

            // Right to Left
            for (int j = right; j >= left && curr != null; j--) {
                ans[bottom][j] = curr.val;
                curr = curr.next;
            }
            bottom--;

            // Bottom to Top
            for (int i = bottom; i >= top && curr != null; i--) {
                ans[i][left] = curr.val;
                curr = curr.next;
            }
            left++;
        }

        return ans;
    }
}