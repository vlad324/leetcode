package io.github.vlad324.n593;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/valid-square/"}
 */
public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);

        final var d1 = dist(p[0], p[1]);
        final var d2 = dist(p[1], p[3]);
        final var d3 = dist(p[3], p[2]);
        final var d4 = dist(p[2], p[0]);

        return d1 != 0
            && d1 == d2 && d2 == d3 && d3 == d4
            && dist(p[0], p[3]) == dist(p[1], p[2]);
    }

    private int dist(int[] a, int[] b) {
        final var dx = a[0] - b[0];
        final var dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}