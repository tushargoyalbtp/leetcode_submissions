class Solution {

    public int functionHelper(Integer[][][] dp, int ind, int canBuy, int cap, int[] prices){
        if(ind == prices.length || cap == 0){
            return 0;
        }
        if(dp[ind][canBuy][cap] != null){
            return dp[ind][canBuy][cap];
        }
        int profit = 0;

        if(canBuy==1){

            //buy
            int buy = -prices[ind] + functionHelper(dp, ind+1, 0, cap, prices);

            // skip
            int skip = 0 + functionHelper(dp, ind+1, 1, cap, prices);

            profit = Math.max(buy, skip);
        }
        else{
            //sell
            int sell = prices[ind] + functionHelper(dp, ind+1, 1, cap-1, prices);

            // skip
            int skip = 0 + functionHelper(dp, ind+1, 0, cap, prices);

            profit = Math.max(sell, skip);
        }

        dp[ind][canBuy][cap] = profit;
        return profit;
    }
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        Integer[][][] dp = new Integer[n][2][3];

        return functionHelper(dp, 0, 1, 2, prices);
    }
}