class Solution {
    // public int functionHelper(int[] prices, int canBuy, int ind, int[][][] dp, int cap) {
    //     if (ind == prices.length || cap == 0) {
    //         return 0;
    //     }

    //     if (dp[ind][canBuy][cap] != 0) {
    //         return dp[ind][canBuy][cap];
    //     }

    //     int profit = 0;

    //     if (canBuy == 1) {
    //         int buy = -prices[ind] + functionHelper(prices, 0, ind + 1, dp, cap);
    //         int skip = functionHelper(prices, 1, ind + 1, dp, cap);
    //         profit = Math.max(buy, skip);
    //     } else {
    //         int sell = prices[ind] + functionHelper(prices, 1, ind + 1, dp, cap - 1);
    //         int skip = functionHelper(prices, 0, ind + 1, dp, cap);
    //         profit = Math.max(sell, skip);
    //     }

    //     dp[ind][canBuy][cap] = profit;
    //     return profit;
    // }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1]; // fix: cap from 0 to k

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (canBuy == 1) {
                        dp[ind][canBuy][cap] = Math.max(-prices[ind] + dp[ind+1][0][cap], dp[ind+1][1][cap]);
                      
                    } else {
                        dp[ind][canBuy][cap] = Math.max(prices[ind] + dp[ind+1][1][cap-1], dp[ind+1][0][cap]);
                    }
                }
            }
        }
        // return functionHelper(prices, 1, 0, dp, k);

        return dp[0][1][k];
    }
}