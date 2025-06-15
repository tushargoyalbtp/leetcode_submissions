class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (subArraySum(mid, nums, k)) {
                high = mid - 1; // try smaller max sum
            } else {
                low = mid + 1; // need bigger max sum
            }

        }

        return low;
    }

    public boolean subArraySum(int mid, int[] nums, int k) {
        int subarryCount = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                subarryCount++;
                sum = nums[i];
            }
        }

        return subarryCount <= k;

    }
}