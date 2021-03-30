package io.github.vlad324.n354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * {@link "https://leetcode.com/problems/russian-doll-envelopes/"}
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));

        final var dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
