class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Create memoization table initialized with null (to check visited)
        Integer[][] dp = new Integer[n][n];

        return dfs(triangle, 0, 0, dp);
    }

    public int dfs(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != null) {
            return dp[row][col]; // Return cached result
        }

        int down = dfs(triangle, row + 1, col, dp);
        int diag = dfs(triangle, row + 1, col + 1, dp);

        dp[row][col] = triangle.get(row).get(col) + Math.min(down, diag);
        return dp[row][col];
    }
}