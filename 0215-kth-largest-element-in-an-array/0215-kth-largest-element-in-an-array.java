class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);
        }

        int x = 0;
        while (k-- > 0) {
            x = maxHeap.poll();  // No need to use Math.max here
        }

        return x;
    }
}