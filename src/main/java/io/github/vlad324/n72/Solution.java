package io.github.vlad324.n72;

/**
 * {@link "https://leetcode.com/problems/edit-distance/"}
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length(), word2.length());
        }

        final int[][] distance = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    distance[i][j] = getSafe(distance, i - 1, j - 1);
                } else {
                    distance[i][j] = 1 + Math.min(getSafe(distance, i - 1, j),
                        Math.min(getSafe(distance, i, j - 1), getSafe(distance, i - 1, j - 1)));
                }
            }
        }

        return distance[word1.length() - 1][word2.length() - 1];
    }

    private int getSafe(int[][] matrix, int i, int j) {
        if (i < 0 && j < 0) {
            return 0;
        } else if (i < 0) {
            return j + 1;
        } else if (j < 0) {
            return i + 1;
        }

        return matrix[i][j];
    }
}
