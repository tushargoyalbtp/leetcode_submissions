class Solution {

    public boolean canPartition(int[] nums) {

        int totalSum  = 0;
        for(int i : nums){
            totalSum += i;
        }

        if(totalSum%2!=0){
            return false;
        }

        int target = totalSum/2;

        int n = nums.length;

        int[][] dp = new int[n][target+1];
        
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        
        return functionHelper(n-1, target, dp, nums);

    }
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

        boolean nottake = functionHelper(index-1,target,dp,nums);

        boolean take = false;
        if(nums[index] <= target){
            take = functionHelper(index-1, target-nums[index], dp, nums);
        }

        dp[index][target] = nottake || take ? 1 : 0;

        return take || nottake;
    }


    // public boolean helper(int index, int[] nums, int n){
        
        // if(index > n){
        //     return false;
        // }

        // int sum1 = partitionSum(0,index, nums);
        // int sum2 = partitionSum(index+1,n,nums);

        // if(sum1==sum2){
        //     return true;
        // }

        // else{
        //     return helper(index+1, nums, n);
        // }

    // }

    // public int partitionSum(int si, int ei, int[] nums){
    //     int sum = 0;
    //     for(int i = si; i<=ei; i++){
    //         sum += nums[i];
    //     }

    //     return sum;
    // }
}



// totalsum = 22

// [1,5,11,5]

// 1<22, i = 0;
// 22-1 -> 21,

// i = 1, 5<21
// 21-5 = 16

// i = 2, 11<16
// 16-11 = 5

// i = 3, 5<=5
// 5-5 = 0;
