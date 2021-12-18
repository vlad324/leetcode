package io.github.vlad324.n221;

/**
 * {@link "https://leetcode.com/problems/maximal-square/"}
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        final var m = matrix.length;
        final var n = matrix[0].length;

        int max = 0;

        final var dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}
