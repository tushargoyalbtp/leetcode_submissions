class Solution {
    public int functionHelper(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if(dp[index]!=-1){
            return dp[index];
        }

        int take = nums[index] + functionHelper(nums, index + 2, dp);
        int nottake = functionHelper(nums, index + 1, dp);

        dp[index] =  Math.max(take, nottake);
        return dp[index];
    }

    public int rob(int[] nums) {
        
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp , -1);
        
        return functionHelper(nums, 0, dp);
    }
}