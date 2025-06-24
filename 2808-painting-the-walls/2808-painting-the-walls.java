// class Solution {
//     public int paintWalls(int[] cost, int[] time) {
//         int n = cost.length;
//         int[][] dp = new int[n + 1][n + 1];

//         for (int i = 0; i <= n; i++) {
//             Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
//         }

//         dp[0][0] = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= n; j++) {
//                 // Skip paid painter
//                 dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);

//                 // Use paid painter on i
//                 int freeAdds = time[i];
//                 int wallsCovered = Math.min(n, j + 1 + freeAdds);
//                 dp[i + 1][wallsCovered] = Math.min(dp[i + 1][wallsCovered], dp[i][j] + cost[i]);
//             }
//         }

//         return dp[n][n];
//     }
// }

// memomzation

class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Integer[][] dp = new Integer[n + 1][n + 1];
        return dfs(0, 0, cost, time, dp);
    }

    public int dfs(int i, int wallsCovered, int[] cost, int[] time, Integer[][] dp) {
        int n = cost.length;
        if (wallsCovered >= n) return 0;
        if (i == n) return Integer.MAX_VALUE / 2;

        if (dp[i][wallsCovered] != null) return dp[i][wallsCovered];

        // skip this paid painter
        int skip = dfs(i + 1, wallsCovered, cost, time, dp);

        // use this paid painter
        int usePaid = cost[i] + dfs(i + 1, Math.min(n, wallsCovered + 1 + time[i]), cost, time, dp);

        return dp[i][wallsCovered] = Math.min(skip, usePaid);
    }
}


// class Solution {
//     public int paintWalls(int[] cost, int[] time) {
//         return dfs(0, 0, cost, time);
//     }

//     // i = index of current wall we're considering for paid painter
//     // wallsCovered = how many walls have been covered so far
//     public int dfs(int i, int wallsCovered, int[] cost, int[] time) {
//         int n = cost.length;
//         if (wallsCovered >= n) return 0; // all walls painted
//         if (i == n) return Integer.MAX_VALUE / 2; // ran out of paid painter choices but still walls left

//         // Option 1: skip paid painter for this wall
//         int skip = dfs(i + 1, wallsCovered, cost, time);

//         // Option 2: pick paid painter for this wall
//         int usePaid = cost[i] + dfs(i + 1, wallsCovered + 1 + time[i], cost, time);

//         return Math.min(skip, usePaid);
//     }
// }
