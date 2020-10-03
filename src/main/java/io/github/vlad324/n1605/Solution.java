package io.github.vlad324.n1605;

/**
 * {@link "https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/"}
 */
class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        final var result = new int[rowSum.length][colSum.length];

        while (true) {
            int mi = -1;
            int mj = -1;
            int minRow = Integer.MAX_VALUE;
            int minCol = Integer.MAX_VALUE;

            for (int i = 0; i < rowSum.length; i++) {
                if (rowSum[i] > 0 && rowSum[i] < minRow) {
                    mi = i;
                    minRow = rowSum[i];
                }
            }
            for (int i = 0; i < colSum.length; i++) {
                if (colSum[i] > 0 && colSum[i] < minCol) {
                    mj = i;
                    minCol = colSum[i];
                }
            }

            if (mi == -1 || mj == -1) {
                break;
            }

            result[mi][mj] = Math.min(minRow, minCol);

            rowSum[mi] -= result[mi][mj];
            colSum[mj] -= result[mi][mj];
        }

        return result;
    }
}
