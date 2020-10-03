package io.github.vlad324.n96;

/**
 * {@link "https://leetcode.com/problems/unique-binary-search-trees/"}
 */
class Solution {

    public int numTrees(int n) {
        final var dp = new int[n];
        return numTrees(n, dp);
    }

    public int numTrees(int n, int[] dp) {
        if (n < 2) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1] == 0) {
                dp[i - 1] = numTrees(i - 1, dp);
            }
            if (dp[n - i] == 0) {
                dp[n - i] = numTrees(n - i, dp);
            }

            count += dp[i - 1] * dp[n - i];
        }

        return count;
    }
}
