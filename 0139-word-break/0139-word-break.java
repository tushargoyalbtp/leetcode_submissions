class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         Set<String> wordSet = new HashSet<>(wordDict);
        
        // Create an array to store whether substrings up to a certain index can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // An empty string can always be segmented
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if substring from j to i exists in the dictionary and whether substring up to j can be segmented
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
