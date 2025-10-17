// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
        
//         int[][] dp = new int[m][n];
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 dp[i][j] = -1;
//             }
//         }

//         return helper(grid, 0, 0, m, n, dp);
//     }

//     private int helper(int[][] grid, int row, int col, int m, int n, int[][] dp) {
       
//         if (row >= m || col >= n) {
//             return Integer.MAX_VALUE;
//         }

//         if (row == m - 1 && col == n - 1) {
//             return grid[row][col];
//         }

//         if(dp[row][col] != -1){
//             return dp[row][col];
//         }

//         int right = helper(grid, row, col + 1, m, n, dp);
//         int down = helper(grid, row + 1, col, m, n, dp);


//         return dp[row][col] = grid[row][col] + Math.min(right, down);
//     }
// }

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

       
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

       
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = grid[i][j];
                } 
              

                else if (i == m - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } 


                else if (j == n - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } 
                
                
                else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}