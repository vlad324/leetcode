package io.github.vlad324.n832;

/**
 * {@link "https://leetcode.com/problems/flipping-an-image/"}
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for (int k = 0; k < A.length; k++) {
            int i = 0;
            int j = A[0].length - 1;
            while (i <= j) {
                result[k][i] = invert(A[k][j]);
                result[k][j] = invert(A[k][i]);

                i++;
                j--;
            }
        }

        return result;
    }

    private int invert(int n) {
        return n == 0 ? 1 : 0;
    }
}
