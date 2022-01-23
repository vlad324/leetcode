package io.github.vlad324.n1291;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/sequential-digits/"}
 */
class Solution {

    private final static int START_INDEX = 0;
    private final static int MAX_INDEX = 1;
    private final static int STEP_INDEX = 2;

    public List<Integer> sequentialDigits(int low, int high) {
        int minDigit = Integer.toString(low).length();
        int maxDigit = Math.min(Integer.toString(high).length(), 9);

        final var result = new ArrayList<Integer>();
        final var dp = generate_dp(maxDigit);
        for (int i = minDigit; i <= maxDigit; i++) {
            int number = dp[i][START_INDEX];
            int max = Math.min(dp[i][MAX_INDEX], high);
            int step = dp[i][STEP_INDEX];

            while (number < low && number <= max) {
                number += step;
            }

            while (number <= max) {
                result.add(number);
                number += step;
            }
        }

        return result;
    }

    private int[][] generate_dp(int max) {
        int[][] dp = new int[max + 1][3];
        int p = 1;
        for (int i = 1; i <= max; i++) {
            dp[i][START_INDEX] = dp[i - 1][START_INDEX] * 10 + i;
            dp[i][MAX_INDEX] = p * (10 - i) + dp[i - 1][MAX_INDEX];
            dp[i][STEP_INDEX] = dp[i - 1][STEP_INDEX] * 10 + 1;
            p *= 10;
        }

        return dp;
    }
}
