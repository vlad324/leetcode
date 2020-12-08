package io.github.vlad324.n1010;

/**
 * {@link "https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/"}
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        final var modulo = new int[60];
        for (final int t : time) {
            if (t % 60 == 0) {
                count += modulo[0];
            } else {
                count += modulo[60 - t % 60];
            }
            modulo[t % 60]++;
        }

        return count;
    }
}
