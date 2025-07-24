import java.util.*;

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;
        long high = 10000000000L;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (countLessEqual(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long mid) {
        long count = 0;
        for (int a : nums1) {
            count += countWithFixedA(a, nums2, mid);
        }
        return count;
    }

    private long countWithFixedA(int a, int[] nums, long mid) {
        int n = nums.length;
        long count = 0;

        if (a == 0) {
            if (mid >= 0) count += n;
        } else if (a > 0) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if ((long) a * nums[m] <= mid) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            count += l;
        } else {
            int l = 0, r = n - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if ((long) a * nums[m] <= mid) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            count += (n - l);
        }

        return count;
    }
}
