package io.github.vlad324.n473;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/matchsticks-to-square/"}
 */
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (final int matchstick : matchsticks) {
            sum += matchstick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);

        return canMakeSquare(matchsticks.length - 1, matchsticks, new int[4], sum / 4);
    }

    private boolean canMakeSquare(int i, int[] matchsticks, int[] sides, int sideLength) {
        if (sideLength == 0) {
            return false;
        }

        if (i < 0) {
            return true;
        }

        for (int j = 0; j < sides.length; j++) {
            if (matchsticks[i] + sides[j] <= sideLength) {
                sides[j] += matchsticks[i];
                if (canMakeSquare(i - 1, matchsticks, sides, sideLength)) {
                    return true;
                }
                sides[j] -= matchsticks[i];
            }
        }

        return false;
    }
}
