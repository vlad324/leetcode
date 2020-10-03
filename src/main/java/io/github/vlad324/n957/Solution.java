package io.github.vlad324.n957;

/**
 * {@link "https://leetcode.com/problems/prison-cells-after-n-days/"}
 */
class Solution {

    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0) {
            return new int[0];
        }

        N = (N - 1) % 14 + 1;

        for (int i = 0; i < N; i++) {
            int previous = cells[0];
            for (int j = 1; j < cells.length - 1; j++) {
                if (previous != cells[j + 1]) {
                    previous = cells[j];
                    cells[j] = 0;
                } else {
                    previous = cells[j];
                    cells[j] = 1;
                }
            }

            if (i == 0) {
                cells[0] = 0;
                cells[cells.length - 1] = 0;
            }
        }

        return cells;
    }
}
