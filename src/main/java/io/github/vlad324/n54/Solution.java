package io.github.vlad324.n54;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/spiral-matrix/"}
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int startColumn = 0;
        int endRow = matrix.length - 1;
        int endColumn = matrix[0].length - 1;

        final var result = new ArrayList<Integer>();
        while (startRow <= endRow && startColumn <= endColumn) {
            for (int i = startColumn; i <= endColumn; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow++;

            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endColumn]);
            }
            endColumn--;

            if (startRow > endRow || startColumn > endColumn) {
                break;
            }

            for (int i = endColumn; i >= startColumn; i--) {
                result.add(matrix[endRow][i]);
            }
            endRow--;

            for (int i = endRow; i >= startRow; i--) {
                result.add(matrix[i][startColumn]);
            }
            startColumn++;
        }

        return result;
    }
}