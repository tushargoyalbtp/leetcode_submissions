import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                // If this sum is closer to target, update it
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move pointers based on comparison
                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    // Exact match found
                    return sum;
                }
            }
        }

        return closestSum;
    }
}