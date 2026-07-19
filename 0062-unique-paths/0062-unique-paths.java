class Solution {
    // int count = 0;

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return helper(0, 0, m, n, dp);
      
    }

    public int helper(int row, int col, int m, int n, int[][] dp) {
        if (row >= m || col >= n) {
            return 0;
        }

        if(row==m-1 || col==n-1){
            return 1;
        }
        if (dp[row][col]!=-1) {
            return dp[row][col];
        }

        // move right
        int down =  helper(row, col + 1, m, n, dp);
        int right = helper(row + 1, col, m, n, dp);
        dp[row][col] = down + right;
        return dp[row][col];
        
    }
}