package io.github.vlad324;

/**
 * {@link "https://leetcode.com/problems/number-of-islands/"}
 * Counting the number of connected components in an undirected graph
 */
public class NumberOfIslands {
    private static final char LAND_MARK = '1';

    private static final byte NEIGHBOR_ROW_POSITION = 0;
    private static final byte NEIGHBOR_COLUMN_POSITION = 1;
    private static final byte[][] NEIGHBORS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        final var rowCount = grid.length;
        final var columnCount = grid[0].length;

        boolean[][] visited = new boolean[rowCount][columnCount];

        int count = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] == LAND_MARK && !visited[i][j]) {
                    visit(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private void visit(int row, int column, char[][] grid, boolean[][] visited) {
        visited[row][column] = true;

        for (final byte[] neighbor : NEIGHBORS) {
            final var neighborRow = row + neighbor[NEIGHBOR_ROW_POSITION];
            final var neighborColumn = column + neighbor[NEIGHBOR_COLUMN_POSITION];

            if (shouldVisit(neighborRow, neighborColumn, grid, visited)) {
                visit(neighborRow, neighborColumn, grid, visited);
            }
        }
    }

    private boolean shouldVisit(int row, int column, char[][] grid, boolean[][] visited) {
        return row >= 0 && row < grid.length
            && column >= 0 && column < grid[0].length
            && grid[row][column] == LAND_MARK
            && !visited[row][column];
    }
}
