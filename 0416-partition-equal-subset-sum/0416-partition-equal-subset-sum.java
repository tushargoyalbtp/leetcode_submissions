class Solution {
    public boolean functionHelper(int index, int target, int[][] dp, int[] nums){
        if(target == 0){
            return true;
        }
        if(index == 0){
            return nums[0] == target;
        }
        if(dp[index][target] != -1){
            return dp[index][target] == 0 ? false : true;
        }

        boolean nottake = functionHelper(index-1, target, dp, nums);

        boolean take = false;
        if(nums[index] <= target){
            take = functionHelper(index-1, target-nums[index], dp, nums);
        }

        dp[index][target] = nottake || take ? 1 : 0;

        return nottake || take ;
    }
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        if(totalSum%2 !=0 ){
            return false;
        }

        int target =  totalSum / 2;
        int[][] dp = new int[nums.length][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return functionHelper(nums.length-1, target, dp, nums);
        
        // Arrays.sort(nums);
        
        // int i = 0;
        
        // int j = nums.length-1;
        
        // int n = nums.length;

        // return functionHelper(nums, i, 0, j, n);
    
    }

    // public boolean functionHelper(int[] nums, int i , int k , int j, int n){
        
    //     int presum = 0;
    //     int aftersum = 0;

    //     if( k+1 == n){
    //         return false;
    //     }
        
    //     for(int p = i; p <= k; p++){
    //         presum += nums[p];
    //     }

    //     for(int q = k+1; q <= j; q++){
    //         aftersum += nums[q];
    //     }

    //     if(presum == aftersum){
    //         return true;
    //     } 
    //     return functionHelper(nums, i, k+1, j, n);
    // }
}