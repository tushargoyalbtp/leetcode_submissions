class Solution {
    public int functionCosts(int i , int j, int[] cuts, int[][] dp){
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = cuts[j + 1] - cuts[i - 1]
                     + functionCosts(i, index - 1, cuts, dp)
                     + functionCosts(index + 1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }

        dp[i][j] = mini;
        return mini;
    }

    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts[i];
        }
        newCuts[0] = 0;
        newCuts[c + 1] = n;

        Arrays.sort(newCuts); // sort after adding 0 and n

        int[][] dp = new int[c + 2][c + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return functionCosts(1, c, newCuts, dp);
    }
}
