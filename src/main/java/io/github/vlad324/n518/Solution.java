package io.github.vlad324.n518;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * {@link "https://leetcode.com/problems/coin-change-2/"}
 */
class Solution {

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        final var solutions = new TreeSet<int[]>(Arrays::compare);
        int[] counts = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            counts[i]++;
            count(amount, coins[i], coins, counts, solutions);
            counts[i]--;

        }
        return solutions.size();
    }

    private void count(int amount, int coin, int[] coins, int[] counts, Set<int[]> solutions) {
        amount -= coin;

        if (amount == 0) {
            solutions.add(Arrays.copyOf(counts, counts.length));
        }

        if (amount < 0) {
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            counts[i]++;
            count(amount, coins[i], coins, counts, solutions);
            counts[i]--;
        }
    }
}
