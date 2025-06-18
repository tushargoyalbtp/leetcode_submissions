// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n + 1];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n + 1; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         return functionHelper(dp, nums, 0, -1, n);
//     }

//     public int functionHelper(int[][] dp, int[] nums, int index, int prev_index, int n) {
//         if (index == n) {
//             return 0;
//         }

//         if (dp[index][prev_index + 1] != -1) {
//             return dp[index][prev_index + 1];
//         }

//         // not take
//         int len = functionHelper(dp, nums, index + 1, prev_index, n);

//         // take
//         if (prev_index == -1 || nums[index] > nums[prev_index]) {
//             len = Math.max(len, 1 + functionHelper(dp, nums, index + 1, index, n));
//         }

//         dp[index][prev_index + 1] = len;
//         return len;
//     }
// }


public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().orElse(0);
        return maxLength;
    }
}