class Solution {

    public boolean functionHelper(int i , int j, int k , int s1length, int s2length, int s3length, String s1, String s2, String s3, boolean[][][] dp){

        if (k == s3length) {
            return i == s1length && j == s2length;
        }

        boolean ans = false;

        if(dp[i][j][k] != false){
            return dp[i][j][k];
        }

        if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            ans = dp[i][j][k] || functionHelper(i + 1, j, k + 1, s1length, s2length, s3length, s1, s2, s3, dp);
        }

        if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            ans = dp[i][j][k] || functionHelper(i, j + 1, k + 1, s1length, s2length, s3length, s1, s2, s3, dp);
        }

        dp[i][j][k] = ans;
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int i = 0;
        int j = 0;
        int k = 0;

        int s1length = s1.length();
        int s2length = s2.length();
        int s3length = s3.length();

        boolean[][][] dp = new boolean[s1length+1][s2length+1][s3length+1];

        if (s1length + s2length != s3length) return false;

        return functionHelper(i, j, k, s1length, s2length, s3length, s1, s2, s3, dp);
    }
}