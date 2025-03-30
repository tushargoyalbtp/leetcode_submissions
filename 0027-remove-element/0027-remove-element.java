class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the next position of a non-val element

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Place non-val element at index k
                k++; // Increment k
            }
        }

        return k; // Number of elements not equal to val
    }
}
