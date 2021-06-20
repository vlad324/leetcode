package io.github.vlad324.n778;

/**
 * {@link "https://leetcode.com/problems/swim-in-rising-water/"}
 */
class Solution {
    private final static int[][] NEIGHBORS = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int swimInWater(int[][] grid) {
        final var N = grid.length;

        int left = 0;
        int right = N * N - 1;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSwim(grid, 0, 0, new boolean[N][N], mid, N)) {
                right = mid - 1;
                result = Math.min(result, mid);
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canSwim(int[][] grid, int i, int j, boolean[][] visited, int t, int N) {
        if (i < 0 || i == N || j < 0 || j == N || visited[i][j] || grid[i][j] > t) {
            return false;
        }

        if (i == N - 1 && j == N - 1) {
            return true;
        }

        visited[i][j] = true;
        for (final var n : NEIGHBORS) {
            if (canSwim(grid, i + n[0], j + n[1], visited, t, N)) {
                return true;
            }
        }

        return false;
    }
}
