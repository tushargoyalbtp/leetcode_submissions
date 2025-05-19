class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || amount==0){
            
                return 0;
            
        }
        
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        
        
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<dp.length;j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE)
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);    
            }
        }
        if(dp[amount]!=Integer.MAX_VALUE){
            return dp[amount];
        }
        else{
            return -1;
        }
        
    }
}