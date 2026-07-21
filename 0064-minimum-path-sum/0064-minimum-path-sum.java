class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        
        int col = grid[0].length;
        int[][] dp = new int[row+1][col+1];

        for(int[] dpi : dp){
            Arrays.fill(dpi, Integer.MAX_VALUE);
        }
        return helper(grid, 0, 0, row,col, dp);
    }

    public int helper(int[][] grid, int i, int j , int row, int col, int[][] dp){

        if(i< 0 || j < 0 || i >= row || j >= col){
            return Integer.MAX_VALUE;
        }

        
        if(i == row-1 && j == col-1){
            return dp[i][j] = grid[i][j];
        }

        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        dp[i][j] = grid[i][j]+Math.min(helper(grid,i+1,j,row,col, dp),helper(grid,i,j+1,row,col,dp));
        return dp[i][j];
    }

    
}