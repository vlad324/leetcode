package io.github.vlad324.n63;

/**
 * {@link "https://leetcode.com/problems/unique-paths-ii/"}
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final var m = obstacleGrid.length;
        final var n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        final var dp = new int[m][n];
        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] != 0 || obstacleGrid[i][j] == 1) {
                    continue;
                }

                dp[i][j] = get(dp, i, j + 1, m, n) + get(dp, i + 1, j, m, n);
            }
        }

        return dp[0][0];
    }

    private int get(int[][] dp, int i, int j, int m, int n) {
        if (i == m || j == n) {
            return 0;
        }

        return dp[i][j];
    }
}
