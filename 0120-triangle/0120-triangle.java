class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        return helperMinimum(dp,0,0,triangle);
    }

    public int helperMinimum(Integer[][] dp, int row, int col, List<List<Integer>> triangle){

        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if(dp[row][col]!=null){
            return dp[row][col];
        }   

        int dow =  helperMinimum(dp, row+1, col, triangle);
        int diag = helperMinimum(dp, row+1, col+1, triangle);

        dp[row][col] = triangle.get(row).get(col) + Math.min(dow,diag);
        return dp[row][col];
    }
}