class Solution {
    public int uniquePaths(int m, int n) {
        // [i][j+1]-> down or [i+1][j]-> right;
        int[][] dp=new int[m+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return helper(dp,0,0,m-1,n-1);
    }

    public int helper(int[][] dp, int i, int j, int row, int col){
        if(row==i && col==j){
            return dp[row][col]=1;
        }

        if(row<i || col<j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int downmove=helper(dp,i,j+1,row,col);
        int rightmove=helper(dp,i+1,j,row,col);
        return dp[i][j]=downmove+rightmove;
    }
}