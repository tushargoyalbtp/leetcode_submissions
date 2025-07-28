import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] maximum = new int[n - k + 1];
        Deque<Integer> d = new ArrayDeque<>();
        int p = 0;

        for (int i = 0; i < n; i++) {
            // Remove indices out of window
            while (!d.isEmpty() && d.peekFirst() <= i - k) {
                d.pollFirst();
            }

            // Remove smaller elements in k range as they are useless
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.pollLast();
            }

            d.addLast(i);

            // Start adding to result once we have the first window
            if (i >= k - 1) {
                maximum[p++] = nums[d.peekFirst()];
            }
        }

        return maximum;
    }
}