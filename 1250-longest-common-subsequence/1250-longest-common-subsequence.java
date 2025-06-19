class Solution {
    public int functionHelper(String text1, String text2, int[][] dp, int index1, int index2){
        
        if(index1 < 0 || index2 < 0){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(text1.charAt(index1) == text2.charAt(index2)){
            dp[index1][index2] = 1 + functionHelper(text1, text2, dp, index1-1, index2-1);
            return dp[index1][index2];
        }
        return dp[index1][index2] = Math.max(functionHelper(text1, text2, dp, index1-1, index2), 
        functionHelper(text1, text2, dp, index1, index2-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        return functionHelper(text1, text2, dp, n-1, m-1);

        // int count = 0;
        // HashMap<Character, Integer> charmap = new HashMap<>();
        // if (text2.length() > text1.length()) {
        //     for (int i = 0; i < text2.length(); i++) {
        //         char ch = text2.charAt(i);
        //         charmap.put(ch, charmap.getOrDefault(ch, 0) + 1);
        //     }

        //     for (int i = 0; i < text1.length(); i++) {
        //         char ch = text1.charAt(i);
        //         if (charmap.containsKey(ch) && charmap.get(ch) > 1) {
        //             charmap.put(ch, charmap.get(ch) - 1);
        //             count++;
        //         } else if (charmap.containsKey(ch) && charmap.get(ch) == 1) {
        //             charmap.remove(ch);
        //             count++;
        //         }
        //     }
        // } else {
        //     for (int i = 0; i < text1.length(); i++) {
        //         char ch = text1.charAt(i);
        //         charmap.put(ch, charmap.getOrDefault(ch, 0) + 1);
        //     }

        //     for (int i = 0; i < text2.length(); i++) {
        //         char ch = text2.charAt(i);
        //         if (charmap.containsKey(ch) && charmap.get(ch) > 1) {
        //             charmap.put(ch, charmap.get(ch) - 1);
        //             count++;
        //         } else if (charmap.containsKey(ch) && charmap.get(ch) == 1) {
        //             charmap.remove(ch);
        //             count++;
        //         }
        //     }
        // }

        // return count;
    }
}