class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int maxNum = nums[0];

        for(int i=1; i<nums.length; i++){
            maxNum = Math.max(nums[i], nums[i]+maxNum);
            res = Math.max(maxNum, res);
        }

        return res;
    }
}