package io.github.vlad324.n51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/n-queens/"}
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        final var board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        final var result = new ArrayList<List<String>>();
        helper(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, result);
        return result;
    }

    public void helper(int i,
                       Set<Integer> columns,
                       Set<Integer> diagonals,
                       Set<Integer> antidiagonals,
                       char[][] board,
                       List<List<String>> result) {
        if (i == board.length) {
            result.add(toList(board));
            return;
        }


        for (int j = 0; j < board[0].length; j++) {
            if (columns.contains(j)) {
                continue;
            }

            final var d = i - j;
            final var ad = i + j;
            if (diagonals.contains(d) || antidiagonals.contains(ad)) {
                continue;
            }

            columns.add(j);
            diagonals.add(d);
            antidiagonals.add(ad);
            board[i][j] = 'Q';

            helper(i + 1, columns, diagonals, antidiagonals, board, result);

            columns.remove(j);
            diagonals.remove(d);
            antidiagonals.remove(ad);
            board[i][j] = '.';
        }
    }

    private List<String> toList(char[][] board) {
        final var result = new ArrayList<String>(board.length);
        for (final char[] row : board) {
            result.add(new String(row));
        }

        return result;
    }
}
