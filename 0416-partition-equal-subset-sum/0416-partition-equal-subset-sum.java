class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num : nums){
            for(int j = target ; j>=num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }

        return dp[target];

        // int i = 0;
        // int j = nums.length - 1;

        // while (i + 1 < j) {
        //     int leftSum = 0;
        //     int rightSum = 0;

        //     // Calculate leftSum from 0 to i
        //     for (int x = 0; x <= i; x++) {
        //         leftSum += nums[x];
        //     }

        //     // Calculate rightSum from j to end
        //     for (int x = j; x < nums.length; x++) {
        //         rightSum += nums[x];
        //     }

        //     int middleSum = 0;
        //     for (int k = i + 1; k < j; k++) {
        //         middleSum += nums[k];
        //     }

        //     int borderSum = leftSum + rightSum;

        //     // System.out.println("i = " + i + ", j = " + j);
        //     // System.out.println("leftSum ---> " + leftSum + " rightSum -----> " + rightSum);
        //     // System.out.println("borderSum ---> " + borderSum + " middleSum -----> " + middleSum);

        //     if (middleSum == borderSum) {
        //         return true;
        //     } else if (middleSum > borderSum) {
        //         i++;
        //     } else {
        //         j--;
        //     }
        // }

        // return false;

        // int sum = 0;

        // for (int i = 0; i < n; i++) {

        //     sum += nums[i];
        //     prefixSum[i] = sum;

        // }
        // for (int i = 0; i < nums.length; i++) {
        //     int firstPartitionSum = partitionSum(0, i, nums);
        //     int secodnParitionSum = partitionSum(i, nums.length, nums);

        //     System.out.println("firstSum ------> " + firstPartitionSum + " secondSum --------> " + secodnParitionSum);

        //     if (firstPartitionSum == secodnParitionSum) {
        //         return true;
        //     }
        // }
        // return false;
    }

    // public int partitionSum(int start, int end, int[] nums) {
    //     int sum = 0;
    //     for (int i = start; i < end; i++) {
    //         sum += nums[i];
    //     }

    //     return sum;
    // }
}