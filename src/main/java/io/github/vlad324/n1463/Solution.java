package io.github.vlad324.n1463;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/cherry-pickup-ii/"}
 */
class Solution {

    private static final int[] dx = new int[]{-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        final var n = grid.length;
        final var m = grid[0].length;

        final var dp = new int[n][m][m];

        for (int i = n - 1; i > 0; i--) {
            for (final int[] row : dp[i]) {
                Arrays.fill(row, -1);
            }

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (dp[i][j][k] != -1) {
                        continue;
                    }

                    int sum = i + 1 != n ? nextLevelMax(dp, i, j, k, m) : 0;
                    if (j == k) {
                        sum += grid[i][j];
                    } else {
                        sum += grid[i][j] + grid[i][k];
                    }

                    dp[i][j][k] = sum;
                    dp[i][k][j] = sum;
                }
            }
        }

        return grid[0][0] + grid[0][m - 1] + nextLevelMax(dp, 0, 0, m - 1, m);
    }

    private int nextLevelMax(int[][][] dp, int level, int j, int k, int columnCount) {
        int max = 0;
        for (int dj : dx) {
            for (int dk : dx) {
                int nj = j + dj;
                int nk = k + dk;

                if (nj >= 0 && nj < columnCount && nk >= 0 && nk < columnCount) {
                    max = Math.max(max, dp[level + 1][nj][nk]);
                }
            }
        }

        return max;
    }
}
