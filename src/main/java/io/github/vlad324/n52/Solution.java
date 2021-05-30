package io.github.vlad324.n52;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link "https://leetcode.com/problems/n-queens-ii/"}
 */
class Solution {
    public int totalNQueens(int n) {
        return helper(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int helper(int row,
                       int n,
                       Set<Integer> columns,
                       Set<Integer> diagonals,
                       Set<Integer> antidiagonals) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }

            int d = row - i;
            int ad = row + i;

            if (diagonals.contains(d) || antidiagonals.contains(ad)) {
                continue;
            }

            columns.add(i);
            diagonals.add(d);
            antidiagonals.add(ad);

            count += helper(row + 1, n, columns, diagonals, antidiagonals);

            antidiagonals.remove(ad);
            diagonals.remove(d);
            columns.remove(i);
        }

        return count;
    }
}