package io.github.vlad324.n1510;

/**
 * {@link "https://leetcode.com/problems/stone-game-iv/"}
 */
class Solution {
    public boolean winnerSquareGame(int n) {
        final var canWin = new Boolean[n + 1];
        canWin[0] = false;
        canWin[1] = true;

        canWin[n] = canWin(n, canWin);
        return canWin[n];
    }

    private boolean canWin(int n, Boolean[] canWin) {
        if (canWin[n] != null) {
            return canWin[n];
        }

        int max = (int) Math.floor(Math.sqrt(n));

        while (max > 0) {
            final var newN = n - (max * max);
            canWin[newN] = canWin(newN, canWin);
            if (!canWin[newN]) {
                return true;
            }
            max--;
        }

        canWin[n] = false;
        return canWin[n];
    }
}