class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = j;  // with 1 egg, need j trials (sequential)
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    int low = 1, high = j;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        int broken = dp[i - 1][mid - 1]; // egg breaks
                        int notBroken = dp[i][j - mid]; // egg survives
                        int temp = 1 + Math.max(broken, notBroken);

                        dp[i][j] = Math.min(dp[i][j], temp);

                        if (broken > notBroken) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                }
            }
        }

        return dp[k][n];
    }
}



// giving TLE
// class Solution {
//     public int superEggDrop(int k, int n) {
//         int[][] dp = new int[n + 1][k + 1];

//         for (int floors = 1; floors <= n; floors++) {
//             for (int eggs = 1; eggs <= k; eggs++) {
//                 if (floors == 1) {
//                     dp[floors][eggs] = 1;
//                 } else if (eggs == 1) {
//                     dp[floors][eggs] = floors;
//                 } else {
//                     int min = Integer.MAX_VALUE;
//                     for (int dropFloor = 1; dropFloor <= floors; dropFloor++) {
//                         int breaks = dp[dropFloor - 1][eggs - 1];     // egg breaks
//                         int survives = dp[floors - dropFloor][eggs];  // egg survives
//                         int worst = 1 + Math.max(breaks, survives);
//                         min = Math.min(min, worst);
//                     }
//                     dp[floors][eggs] = min;
//                 }
//             }
//         }

//         return dp[n][k];
//     }
// }
