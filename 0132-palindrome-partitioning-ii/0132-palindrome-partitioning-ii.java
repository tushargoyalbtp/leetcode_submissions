class Solution {
    public boolean isPalindrome(int i , int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int functionhelper(int i, int n, String s, int[] dp){
        if(i==n) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            if(isPalindrome(i,j,s)){
                int cost = 1 + functionhelper(j+1, n, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        dp[i] = minCost;
        return minCost;
    }
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        int n = s.length();
        return functionhelper(0, n, s, dp)-1;

    }
}