package io.github.vlad324.n329;

/**
 * {@link "https://leetcode.com/problems/longest-increasing-path-in-a-matrix/"}
 */
class Solution {
    private static final int[][] NEIGHBORS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        final var m = matrix.length;
        final var n = matrix[0].length;
        final var dp = new int[m][n];

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dfs(matrix, i, j, dp, m, n);
                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp, int m, int n) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int result = 1;
        for (final var dx : NEIGHBORS) {
            final var ni = i + dx[0];
            final var nj = j + dx[1];
            if (isPossible(m, n, ni, nj) && matrix[ni][nj] > matrix[i][j]) {
                dp[ni][nj] = dfs(matrix, ni, nj, dp, m, n);
                result = Math.max(result, dp[ni][nj] + 1);
            }
        }

        return result;
    }

    private boolean isPossible(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
