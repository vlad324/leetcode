package io.github.vlad324.n174;

/**
 * {@link "https://leetcode.com/problems/dungeon-game/"}
 */
class Solution {

    private final int[][] neighbor = new int[][]{{0, 1}, {1, 0}};

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }

        Integer[][] dp = new Integer[dungeon.length][dungeon[0].length];
        return calculateMinimumHP(dungeon, 0, 0, dp);
    }

    private int calculateMinimumHP(int[][] dungeon, int i, int j, Integer[][] dp) {
        if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
            return dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int minHp = Integer.MAX_VALUE;
        for (int[] n : neighbor) {
            int ni = i + n[0];
            int nj = j + n[1];

            if (ni < dungeon.length && nj < dungeon[0].length) {
                minHp = Math.min(minHp, calculateMinimumHP(dungeon, ni, nj, dp) - dungeon[i][j]);
            }
        }

        return dp[i][j] = Math.max(1, minHp);
    }
}
