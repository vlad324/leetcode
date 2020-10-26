package io.github.vlad324.n799;

/**
 * {@link "https://leetcode.com/problems/champagne-tower/"}
 */
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        final var tower = new double[query_row + 1][query_row + 1];
        tower[0][0] = poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (tower[i][j] > 1) {
                    double halfOfExceededAmount = (tower[i][j] - 1) / 2.0;
                    tower[i][j] = 1;

                    tower[i + 1][j] += halfOfExceededAmount;
                    tower[i + 1][j + 1] += halfOfExceededAmount;
                }
            }
        }

        return Math.min(1, tower[query_row][query_glass]);
    }
}
