package io.github.vlad324.n1091;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/shortest-path-in-binary-matrix/"}
 */
class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        final var n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        final var queue = new LinkedList<int[]>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;

        int steps = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            steps++;
            for (int i = 0; i < count; i++) {
                final var current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (x == n - 1 && y == n - 1) {
                    return steps;
                }

                for (int[] d : DIRECTIONS) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        grid[nx][ny] = 1;
                    }
                }
            }
        }

        return -1;
    }
}
