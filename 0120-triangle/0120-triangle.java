class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int n = triangle.size();
        // // Create memoization table initialized with null (to check visited)
        // Integer[][] dp = new Integer[n][n];

        // return dfs(triangle, 0, 0, dp);

        int n = triangle.size();
        int[] dp = new int[n];

        // Copy last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    // public int dfs(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {
    //     if (row == triangle.size() - 1) {
    //         return triangle.get(row).get(col);
    //     }

    //     if (dp[row][col] != null) {
    //         return dp[row][col]; // Return cached result
    //     }

    //     int down = dfs(triangle, row + 1, col, dp);
    //     int diag = dfs(triangle, row + 1, col + 1, dp);

    //     dp[row][col] = triangle.get(row).get(col) + Math.min(down, diag);
    //     return dp[row][col];
    // }
}