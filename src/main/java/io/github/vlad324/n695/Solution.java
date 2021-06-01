package io.github.vlad324.n695;

import java.util.LinkedList;

/**
 * {@link "https://leetcode.com/problems/max-area-of-island/"}
 */
class Solution {

    private final int[][] NEIGHBOURS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, calculateAreaDFS(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private boolean valid(int x, int y, int rows, int columns) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    private int calculateAreaDFS(int[][] grid, int i, int j) {
        if (!valid(i, j, grid.length, grid[0].length) || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        int area = 1;
        for (final var n : NEIGHBOURS) {
            area += calculateAreaDFS(grid, i + n[0], j + n[1]);
        }

        return area;
    }

    private int calculateArea(int[][] grid, int i, int j) {
        int area = 0;

        final var queue = new LinkedList<int[]>();
        queue.push(new int[]{i, j});
        while (!queue.isEmpty()) {
            final var current = queue.poll();

            final var x = current[0];
            final var y = current[1];
            if (grid[x][y] == 1) {
                area++;
                grid[x][y] = 2;
            }

            for (final var n : NEIGHBOURS) {
                int nx = x + n[0];
                int ny = y + n[1];

                if (valid(nx, ny, grid.length, grid[0].length) && grid[nx][ny] == 1) {
                    queue.push(new int[]{nx, ny});
                }
            }
        }

        return area;
    }
}