class Solution {
    public int functionHelper(int[][] dp, int[][] grid, int n, int m, int row, int col) {
        // If row or col goes out of bounds
        if (row >= n || col >= m) {
            return Integer.MAX_VALUE; // return large value, since this path is invalid
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }
        // If we reach the bottom-right cell
        if (row == n - 1 && col == m - 1) {
           return  dp[row][col] = grid[row][col];
        }

        // Choose min path: right or down
        return dp[row][col] = grid[row][col] + Math.min(
            functionHelper(dp, grid, n, m, row + 1, col),
            functionHelper(dp, grid, n, m, row, col + 1)
        );
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return functionHelper(dp, grid, n, m, 0, 0);
    }
}
