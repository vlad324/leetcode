package io.github.vlad324.n1654;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/minimum-jumps-to-reach-home/"}
 */
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) {
            return 0;
        }

        if (a == x) {
            return 1;
        }

        final var forbiddenSet = new HashSet<Integer>();
        for (final var f : forbidden) {
            forbiddenSet.add(f);
        }

        final var result = helper(forbiddenSet, a, b, x, 0, 0, false, new int[2][4000]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int helper(Set<Integer> forbidden, int a, int b, int x, int current, int count, boolean backAllowed, int[][] dp) {
        if (forbidden.contains(current) || current < 0 || current >= 2_000 || count > 2000) {
            return Integer.MAX_VALUE;
        }

        if (dp[0][current] != 0 && dp[1][current] != 0) {
            return backAllowed ? Math.min(dp[0][current], dp[1][current]) : dp[0][current];
        }

        if (current == x) {
            return count;
        }

        dp[0][current] = helper(forbidden, a, b, x, current + a, count + 1, true, dp);

        if (backAllowed) {
            dp[1][current] = helper(forbidden, a, b, x, current - b, count + 1, false, dp);
            return Math.min(dp[0][current], dp[1][current]);
        }

        return dp[0][current];
    }
}
