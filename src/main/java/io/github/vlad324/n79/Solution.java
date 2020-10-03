package io.github.vlad324.n79;

/**
 * {@link "https://leetcode.com/problems/word-search/"}
 */
class Solution {

    private static final int[][] NEIGHBORS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        final var chars = word.toCharArray();
        final var visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == chars[0] && dfs(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int k) {
        if (chars.length == k) {
            return true;
        }

        if (i < 0 || i >= board.length
            || j < 0 || j >= board[0].length
            || visited[i][j]
            || board[i][j] != chars[k]) {
            return false;
        }

        visited[i][j] = true;

        final var nk = k + 1;
        for (int[] n : NEIGHBORS) {
            final int ni = i + n[0];
            final int nj = j + n[1];

            if (dfs(board, chars, visited, ni, nj, nk)) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;
    }
}
