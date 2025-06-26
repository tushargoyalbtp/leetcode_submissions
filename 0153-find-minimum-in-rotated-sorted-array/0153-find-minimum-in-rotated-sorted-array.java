class Solution {
    public int findMin(int[] nums) {
        int ans = 0;

        int l = 0;
        int h = nums.length - 1;


        while (l < h) {
            int m = l + (h - l) / 2;

            // If the mid element is greater than the rightmost element, the minimum is in the right part
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                // Otherwise, the minimum is in the left part, or it could be the mid element itself
                h = m;
            }
        }
        

        return nums[l];
    }
}