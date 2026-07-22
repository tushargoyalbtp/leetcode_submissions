class Solution {
    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, -1);
            }
        }

        return helper(grid, m, n, 0, n - 1, 0, dp);
    }

    public int helper(int[][] grid, int m, int n,
                      int rcol1, int rcol2,
                      int row, int[][][] dp) {

        // Out of bounds
        if (rcol1 < 0 || rcol1 >= n ||
            rcol2 < 0 || rcol2 >= n) {

            return Integer.MIN_VALUE;
        }

        // Already calculated
        if (dp[row][rcol1][rcol2] != -1) {
            return dp[row][rcol1][rcol2];
        }

        // Calculate current cherries
        int current;

        if (rcol1 == rcol2) {
            current = grid[row][rcol1];
        } else {
            current = grid[row][rcol1] + grid[row][rcol2];
        }

        // Last row
        if (row == m - 1) {
            return dp[row][rcol1][rcol2] = current;
        }

        int max = Integer.MIN_VALUE;

        // Try all 9 combinations
        for (int d = -1; d <= 1; d++) {
            for (int l = -1; l <= 1; l++) {

                max = Math.max(
                    max,
                    helper(
                        grid,
                        m,
                        n,
                        rcol1 + d,
                        rcol2 + l,
                        row + 1,
                        dp
                    )
                );
            }
        }

        return dp[row][rcol1][rcol2] = current + max;
    }
}