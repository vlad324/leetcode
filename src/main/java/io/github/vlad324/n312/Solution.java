package io.github.vlad324.n312;

/**
 * {@link "https://leetcode.com/problems/burst-balloons/"}
 */
class Solution {
    public int maxCoins(int[] nums) {
        final var n = nums.length;
        final var arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);

        final var dp = new int[n + 2][n + 2];

        for (int window = 1; window <= n; window++) {
            for (int left = 1; left <= n - window + 1; left++) {
                final var right = left + window - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                        (arr[left - 1] * arr[i] * arr[right + 1]) + dp[left][i - 1] + dp[i + 1][right]);

                }
            }
        }

        return dp[1][n];
    }
}
