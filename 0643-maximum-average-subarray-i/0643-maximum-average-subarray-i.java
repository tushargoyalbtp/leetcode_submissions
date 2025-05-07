class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Base case: if the array length is less than k, return 0.0
        if (nums.length < k) {
            return 0.0;
        }

        // Calculate the sum of the first 'k' elements
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Initialize the maximum average as the average of the first 'k' elements
        double maxAverage = sum / k;

        // Use a sliding window to calculate the sum of each subarray of length 'k'
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i]; // Slide the window forward
            maxAverage = Math.max(maxAverage, sum / k); // Update the maximum average
        }

        return maxAverage;
    }
}
