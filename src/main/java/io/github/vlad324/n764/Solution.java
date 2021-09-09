package io.github.vlad324.n764;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/largest-plus-sign/"}
 */
class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        final var dp = new int[n][n];
        for (final int[] d : dp) {
            Arrays.fill(d, n);
        }

        for (final int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }

        for (int i = 0; i < n; i++) {
            int countLeft = 0;
            int countUp = 0;
            for (int j = 0; j < n; j++) {
                countLeft = dp[i][j] == 0 ? 0 : countLeft + 1;
                dp[i][j] = Math.min(dp[i][j], countLeft);

                countUp = dp[j][i] == 0 ? 0 : countUp + 1;
                dp[j][i] = Math.min(dp[j][i], countUp);
            }

            int countRight = 0;
            int countDown = 0;
            for (int j = n - 1; j >= 0; j--) {
                countRight = dp[i][j] == 0 ? 0 : countRight + 1;
                dp[i][j] = Math.min(dp[i][j], countRight);

                countDown = dp[j][i] == 0 ? 0 : countDown + 1;
                dp[j][i] = Math.min(dp[j][i], countDown);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}
