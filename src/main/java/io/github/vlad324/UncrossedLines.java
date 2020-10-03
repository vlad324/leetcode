package io.github.vlad324;

public class UncrossedLines {
    public int maxUncrossedLines(int[] a, int[] b) {
        final int[][] counts = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    counts[i][j] = 1 + getSafe(counts, i - 1, j - 1);
                } else {
                    counts[i][j] = Math.max(getSafe(counts, i - 1, j), getSafe(counts, i, j - 1));
                }
            }
        }

        return counts[a.length - 1][b.length - 1];
    }

    private int getSafe(int[][] matrix, int i, int j) {
        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            return matrix[i][j];
        }

        return 0;
    }
}
