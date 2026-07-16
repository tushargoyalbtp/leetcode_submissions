class Solution {
    public int maxSubArray(int[] nums) {

        int res = nums[0];
        int maxans = nums[0];

        for(int i = 1; i < nums.length; i++){
            res = Math.max(nums[i], nums[i] + res);
            maxans = Math.max(maxans, res);
        }

        return maxans;
    }
}