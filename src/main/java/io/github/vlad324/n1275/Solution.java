package io.github.vlad324.n1275;

/**
 * {@link "https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/"}
 */
class Solution {
    public String tictactoe(int[][] moves) {
        if (moves.length < 5) {
            return "Pending";
        }

        var player = 1;
        final var rows = new int[3];
        final var columns = new int[3];
        int diagonal = 0;
        int antidiagonal = 0;
        int r, c;
        for (final int[] move : moves) {
            r = move[0];
            c = move[1];

            rows[r] += player;
            columns[c] += player;

            if (r == c) {
                diagonal += player;
            }

            if ((r + c) == 2) {
                antidiagonal += player;
            }

            if (rows[r] == 3 || rows[r] == -3 ||
                columns[c] == 3 || columns[c] == -3 ||
                diagonal == 3 || diagonal == -3 ||
                antidiagonal == 3 || antidiagonal == -3) {
                return player == 1 ? "A" : "B";
            }

            player *= -1;
        }

        return moves.length < 9 ? "Pending" : "Draw";
    }
}
