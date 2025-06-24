class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                // Skip paid painter
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);

                // Use paid painter on i
                int freeAdds = time[i];
                int wallsCovered = Math.min(n, j + 1 + freeAdds);
                dp[i + 1][wallsCovered] = Math.min(dp[i + 1][wallsCovered], dp[i][j] + cost[i]);
            }
        }

        return dp[n][n];
    }
}
