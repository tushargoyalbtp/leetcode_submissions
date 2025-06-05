class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1]; // +1 to handle -1 index logic

        return functionHelper(m - 1, n - 1, p, s, dp);
    }

    public boolean functionHelper(int plength, int slength, String p, String s, Boolean[][] dp){
        // Base cases
        if (plength < 0 && slength < 0) return true;
        if (plength < 0 && slength >= 0) return false;
        if (slength < 0 && plength >= 0) {
            for (int i = 0; i <= plength; i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }

        if (dp[plength + 1][slength + 1] != null) return dp[plength + 1][slength + 1];

        char pc = p.charAt(plength);
        char sc = s.charAt(slength);

        boolean ans;
        if (pc == sc || pc == '?') {
            ans = functionHelper(plength - 1, slength - 1, p, s, dp);
        } else if (pc == '*') {
            ans = functionHelper(plength - 1, slength, p, s, dp) || // '*' matches empty
                  functionHelper(plength, slength - 1, p, s, dp);   // '*' matches one char
        } else {
            ans = false;
        }

        dp[plength + 1][slength + 1] = ans;
        return ans;
    }
}
