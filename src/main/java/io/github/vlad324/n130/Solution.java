package io.github.vlad324.n130;

/**
 * {@link "https://leetcode.com/problems/surrounded-regions/"}
 */
class Solution {

    private static final char O_CHAR = 'O';
    private static final char X_CHAR = 'X';

    private static final int[][] NEIGHBOR = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) {
            return;
        }

        final var visited = new boolean[board.length][board[0].length];

        for (int j = 0; j < board[0].length; j++) {
            dsf(board, 0, j, visited);
            dsf(board, board.length - 1, j, visited);
        }

        for (int i = 1; i < board.length - 1; i++) {
            dsf(board, i, 0, visited);
            dsf(board, i, board[0].length - 1, visited);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == O_CHAR && !visited[i][j]) {
                    board[i][j] = X_CHAR;
                }
            }
        }
    }

    private void dsf(char[][] board, int i, int j, boolean[][] visited) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j] && board[i][j] == O_CHAR) {
            visited[i][j] = true;
            for (int[] d : NEIGHBOR) {
                dsf(board, i + d[0], j + d[1], visited);
            }
        }
    }
}
