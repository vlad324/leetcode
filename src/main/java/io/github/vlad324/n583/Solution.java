package io.github.vlad324.n583;

/**
 * {@link "https://leetcode.com/problems/delete-operation-for-two-strings/"}
 */
class Solution {
    public int minDistance(String word1, String word2) {
        final var w1 = word1.length();
        final var w2 = word2.length();
        final var dp = new int[w1 + 1][w2 + 1];

        for (int i = 0; i <= w1; i++) {
            for (int j = 0; j <= w2; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return w1 + w2 - 2 * dp[w1][w2];
    }
}