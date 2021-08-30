package io.github.vlad324.n733;

import java.util.ArrayDeque;

/**
 * {@link "https://leetcode.com/problems/flood-fill/"}
 */
class Solution {
    private static final byte[][] NEIGHBORS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final var queue = new ArrayDeque<int[]>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            final var current = queue.poll();
            final var currentColor = image[current[0]][current[1]];
            if (currentColor == newColor) {
                continue;
            }

            for (final var d : NEIGHBORS) {
                int nx = current[0] + d[0];
                int ny = current[1] + d[1];

                if (getSafe(image, nx, ny) == currentColor) {
                    queue.add(new int[]{nx, ny});
                }
            }

            image[current[0]][current[1]] = newColor;
        }

        return image;
    }

    public int[][] floodFill_dfs(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        if (image[i][j] == newColor) {
            return;
        }

        image[i][j] = newColor;
        for (final var d : NEIGHBORS) {
            int nx = i + d[0];
            int ny = j + d[1];

            if (getSafe(image, nx, ny) == oldColor) {
                dfs(image, nx, ny, newColor, oldColor);
            }
        }
    }

    private int getSafe(int[][] image, int i, int j) {
        return i >= 0 && i < image.length && j >= 0 && j < image[0].length ? image[i][j] : -1;
    }
}
