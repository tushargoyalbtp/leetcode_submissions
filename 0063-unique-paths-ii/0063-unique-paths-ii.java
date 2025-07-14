class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return functionHelper(obstacleGrid, 0, 0, m, n, dp);
    }

    public int functionHelper(int[][] grid, int row, int col, int m, int n, int[][] dp) {
        if (row >= m || col >= n || grid[row][col] == 1) return 0;
        if (row == m - 1 && col == n - 1) return 1;
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        dp[row][col] = functionHelper(grid, row + 1, col, m, n, dp) +
               functionHelper(grid, row, col + 1, m, n, dp);
        
        return dp[row][col];
    }
}