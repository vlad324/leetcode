package io.github.vlad324.n309;

/**
 * {@link "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/"}
 */
class Solution {

    private static final int BUY_INDEX = 0;
    private static final int SELL_INDEX = 1;

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        } else if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }

        final var n = prices.length;

        final int[][] dp = new int[n][2];
        dp[n - 1][BUY_INDEX] = 0;
        dp[n - 2][BUY_INDEX] = Math.max(0, prices[n - 1] - prices[n - 2]);

        dp[n - 1][SELL_INDEX] = prices[n - 1];
        dp[n - 2][SELL_INDEX] = Math.max(prices[n - 1], prices[n - 2]);

        for (int i = n - 3; i >= 0; i--) {
            final int buyProfit = dp[i + 1][SELL_INDEX] - prices[i];
            final int waitProfit = dp[i + 1][BUY_INDEX];
            dp[i][BUY_INDEX] = Math.max(buyProfit, waitProfit);

            final int sellProfit = prices[i] + dp[i + 2][BUY_INDEX];
            final int holdProfit = dp[i + 1][SELL_INDEX];
            dp[i][SELL_INDEX] = Math.max(sellProfit, holdProfit);
        }

        return dp[0][BUY_INDEX];
    }
}