package io.github.vlad324.n542;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/01-matrix/"}
 */
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        final var result = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], 100_000_000);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    if (i > 0) {
                        result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    }

                    if (j > 0) {
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i < n - 1) {
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                }

                if (j < m - 1) {
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }

        return result;
    }
}
