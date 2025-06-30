class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Ensure binary search on smaller array
        if(n > m) {
            return findMedianSortedArrays(nums2, nums1); // ✅ Return this result
        }

        int low = 0, high = n;
        int total = n + m;
        int left = (total + 1) / 2;

        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];

            int r1 = (mid1 == n) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2 <= r1) {
                if(total % 2 == 1) {
                    return (double)Math.max(l1, l2);
                } else {
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0.0; // Should not reach here
    }
}
