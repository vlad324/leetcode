package io.github.vlad324.n417;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/pacific-atlantic-water-flow/solution/"}
 */
class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        final var pacificReachable = new boolean[matrix.length][matrix[0].length];
        final var atlanticReachable = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, i, 0, pacificReachable);
            dfs(matrix, i, matrix[0].length - 1, atlanticReachable);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, 0, i, pacificReachable);
            dfs(matrix, matrix.length - 1, i, atlanticReachable);
        }

        final var commonCells = new ArrayList<List<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }

        return commonCells;
    }

    private void dfs(int[][] landHeights, int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= reachable.length || newCol < 0 || newCol >= reachable[0].length) {
                continue;
            }

            if (reachable[newRow][newCol]) {
                continue;
            }

            if (landHeights[newRow][newCol] < landHeights[row][col]) {
                continue;
            }

            dfs(landHeights, newRow, newCol, reachable);
        }
    }
}
