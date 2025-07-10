class Solution {

    public int functionHelper(int ind, int canBuy , int[] prices, Integer[][] dp){
        if(ind == prices.length){
            return 0;
        }

        if(dp[ind][canBuy] != null){
            return dp[ind][canBuy];
        }

        int profit = 0;

        if(canBuy == 1){
            int buy = -prices[ind] + functionHelper(ind+1, 0, prices, dp);

            int skip = functionHelper(ind+1, 1, prices, dp);

            profit = Math.max(buy, skip);
        }

        else{
            // sell
            int sell = prices[ind] + functionHelper(ind+1, 1, prices, dp);
            // skip

            int skip = functionHelper(ind+1, 0, prices, dp);

            profit = Math.max(sell, skip);

        }

        dp[ind][canBuy] = profit;

        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        Integer[][] dp = new Integer[n][2];

        
        return functionHelper(0, 1, prices, dp);
    }
}