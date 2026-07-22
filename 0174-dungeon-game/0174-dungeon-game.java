class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        Integer[][] dp = new Integer[m][n];

        return helper(dungeon, 0, 0,dp);

    }

    public int helper(int[][] dungeon, int i, int j, Integer[][] dp){

        if(i<0 || j<0 || i>=dungeon.length || j >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }

        if(i == dungeon.length-1 && j == dungeon[0].length-1){
            return dp[i][j] =  Math.max(1, 1-dungeon[i][j]);
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int minHealth = Math.min(helper(dungeon, i+1, j, dp),helper(dungeon, i, j+1, dp));
        return dp[i][j] = Math.max(1, minHealth - dungeon[i][j]); 
    }
}



// [
//     [-2,-3,3]
//     [-5,-10,1]
//     [10,30,-5]
// ]


// -2-3+3+1-5
