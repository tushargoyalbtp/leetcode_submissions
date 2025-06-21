class Solution {

    public int functionHelper(int[][] dp, int i, int j, String word1, String word2){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return functionHelper(dp, i-1, j-1, word1, word2);
        }
        return dp[i][j] = 1+Math.min(functionHelper(dp, i-1, j, word1, word2) , Math.min(functionHelper(dp, i,j-1,word1, word2), functionHelper(dp, i-1, j-1, word1, word2)));

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }


        return functionHelper(dp, n-1, m-1, word1, word2);
    }
}