class Solution {
    public int searchInsert(int[] nums, int target) {

        int ans = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return i;
        
    }
}