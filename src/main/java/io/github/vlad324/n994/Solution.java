package io.github.vlad324.n994;

import java.util.ArrayDeque;

/**
 * {@link "https://leetcode.com/problems/rotting-oranges/"}
 */
class Solution {

    private static final byte[][] NEIGHBORS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private final static int FRESH = 1;
    private final static int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        final var m = grid.length;
        final var n = grid[0].length;

        int freshCount = 0;
        final var queue = new ArrayDeque<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ROTTEN) {
                    queue.addLast(new int[]{i, j});
                } else if (grid[i][j] == FRESH) {
                    freshCount++;
                }
            }
        }

        int days = 0;
        while (freshCount > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                final var current = queue.removeFirst();
                for (final var d : NEIGHBORS) {
                    int ni = current[0] + d[0];
                    int nj = current[1] + d[1];

                    if (valid(ni, nj, m, n) && grid[ni][nj] == FRESH) {
                        grid[ni][nj] = ROTTEN;
                        freshCount--;
                        queue.addLast(new int[]{ni, nj});
                    }
                }
            }

            if (!queue.isEmpty()) {
                days++;
            }
        }

        return freshCount == 0 ? days : -1;
    }

    private boolean valid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}