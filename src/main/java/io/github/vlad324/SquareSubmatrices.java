package io.github.vlad324;

/**
 * {@link "https://leetcode.com/problems/count-square-submatrices-with-all-ones/"}
 */
public class SquareSubmatrices {

    private static final int MARK = 0;

    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    count += matrix[i][j];
                } else if (matrix[i][j] != MARK) {
                    int maxSquareSize = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                    count += maxSquareSize;
                    matrix[i][j] = maxSquareSize;
                }
            }
        }

        return count;
    }
}
