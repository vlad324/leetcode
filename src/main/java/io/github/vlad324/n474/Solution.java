package io.github.vlad324.n474;

/**
 * {@link "https://leetcode.com/problems/ones-and-zeroes/"}
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        final var dp = new int[m + 1][n + 1];
        for (final String str : strs) {
            final var zeros = count0(str);
            final var ones = str.length() - zeros;
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private int count0(String str) {
        int count = 0;
        for (final char c : str.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }

        return count;
    }
}
