class Solution {

public int lcs(String text1, String text2){
            // tabulation-approach
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {

            dp[i][0] = 0;

        }
        for (int j = 0; j < m + 1; j++) {

            dp[0][j] = 0;

        }


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public int longestPalindromeSubseq(String s) {
        String text2 = reverse(s);
        return lcs(s, text2);
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}