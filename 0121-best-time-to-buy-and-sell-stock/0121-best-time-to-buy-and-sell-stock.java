// class Solution {
//     public int maxProfit(int[] prices) {
//         int minPrice = Integer.MAX_VALUE;
//         int maxProfit = 0;

//         for (int price : prices) {
//             if (price < minPrice) {
//                 minPrice = price; // update min price so far
//             } else {
//                 maxProfit = Math.max(maxProfit, price - minPrice); // check profit if we sell today
//             }
//         }

//         return maxProfit;
//     }
// }


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2];

        // Base cases
        dp[0][0] = 0;          // Not holding on day 0
        dp[0][1] = -prices[0]; // Holding on day 0 (we bought)

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);  // Only one buy allowed
        }

        return dp[n-1][0];  // Max profit is when not holding stock at the end
    }
}