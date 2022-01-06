package io.github.vlad324.n1094;

/**
 * {@link "https://leetcode.com/problems/car-pooling/"}
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        final var points = new int[1001];
        for (final var t : trips) {
            points[t[1]] -= t[0];
            points[t[2]] += t[0];
        }

        for (final int pointPassengers : points) {
            capacity += pointPassengers;

            if (capacity < 0) {
                return false;
            }
        }

        return true;
    }
}
