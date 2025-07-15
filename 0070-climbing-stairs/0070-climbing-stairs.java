class Solution {

    public int functionHelper(int n, int index, int[] dp){

        if(index == n){
            return 1;
        }
        if(index > n){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        dp[index] = functionHelper(n, index+1, dp) + functionHelper(n, index+2, dp);
        return dp[index];

    }
    public int climbStairs(int n) {
        
        int[] dp = new int[n];
        
        Arrays.fill(dp, -1);

        return functionHelper(n, 0, dp);

    }
}