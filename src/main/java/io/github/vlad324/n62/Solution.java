package io.github.vlad324.n62;

/**
 * {@link "https://leetcode.com/problems/unique-paths/"}
 */
class Solution {

    private final static int[][] NEIGHBOURS = new int[][]{{0, 1}, {1, 0}};

    public int uniquePaths(int m, int n) {
        final var dp = new int[m][n];
        return find(0, 0, m, n, dp);
    }

    private int find(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int sum = 0;
        for (final var d : NEIGHBOURS) {
            final var ni = i + d[0];
            final var nj = j + d[1];

            if (ni < m && nj < n) {
                sum += find(ni, nj, m, n, dp);
            }
        }

        dp[i][j] = sum;

        return sum;
    }
}
