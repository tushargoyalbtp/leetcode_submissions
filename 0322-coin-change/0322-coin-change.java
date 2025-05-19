class Solution {
    public int coinChange(int[] coins, int amount) {
        // if(coins.length==0 || amount==0){
            
        //         return 0;
            
        // }
        
        // int[] dp=new int[amount+1];
        // Arrays.fill(dp,Integer.MAX_VALUE);
        // dp[0]=0;
        
        
        // for(int i=0;i<coins.length;i++){
        //     for(int j=coins[i];j<dp.length;j++){
        //         if(dp[j-coins[i]]!=Integer.MAX_VALUE)
        //         dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);    
        //     }
        // }
        // if(dp[amount]!=Integer.MAX_VALUE){
        //     return dp[amount];
        // }
        // else{
        //     return -1;
        // }


        //Optimized solution
        int MAX = amount + 1; 
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0; 

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == MAX ? -1 : dp[amount];
        
    }
}