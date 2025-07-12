class Solution {

    public boolean functionHelper(int i , int j, int k , int s1length, int s2length, int s3length, String s1, String s2, String s3, Boolean[][][] dp){

        if (k == s3length) {
            return i == s1length && j == s2length;
        }

        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }

        boolean ans = false;

        if (i < s1length && s3.charAt(k) == s1.charAt(i)) {
            ans = ans || functionHelper(i + 1, j, k + 1, s1length, s2length, s3length, s1, s2, s3, dp);
        }

        if (j < s2length && s3.charAt(k) == s2.charAt(j)) {
            ans = ans || functionHelper(i, j + 1, k + 1, s1length, s2length, s3length, s1, s2, s3, dp);
        }

        dp[i][j][k] = ans;
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int s1length = s1.length();
        int s2length = s2.length();
        int s3length = s3.length();

        if (s1length + s2length != s3length) return false;

        Boolean[][][] dp = new Boolean[s1length + 1][s2length + 1][s3length + 1];

        return functionHelper(0, 0, 0, s1length, s2length, s3length, s1, s2, s3, dp);
    }
}