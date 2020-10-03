package io.github.vlad324.n441;

/**
 * {@link "https://leetcode.com/problems/arranging-coins/"}
 */
class Solution {

    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8 * (long) n) - 1) / 2);
    }
}
