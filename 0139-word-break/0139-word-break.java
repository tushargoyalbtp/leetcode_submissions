class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> setString = new HashSet<>(wordDict);
        Iterator<String> it = setString.iterator();
        System.out.print("The iterator values are: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && setString.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}