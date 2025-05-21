class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(
                Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++){
            pQueue.offer(nums[i]);
        }
        int ans = 0;
        while(k > 0){
            ans = pQueue.poll();
            k--;
        }

        return ans;

    }
}