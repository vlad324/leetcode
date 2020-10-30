package io.github.vlad324.n986;

import java.util.ArrayList;

/**
 * {@link "https://leetcode.com/problems/interval-list-intersections/"}
 */
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0 || A[A.length - 1][1] < B[0][0] || B[B.length - 1][1] < A[0][0]) {
            return new int[0][0];
        }

        int i = 0;
        int j = 0;

        final var result = new ArrayList<int[]>();
        while (i < A.length && j < B.length) {
            int intervalAStart = A[i][0];
            int intervalAEnd = A[i][1];

            int intervalBStart = B[j][0];
            int intervalBEnd = B[j][1];

            if (intervalAEnd < intervalBStart) {
                i++;
                continue;
            }

            if (intervalBEnd < intervalAStart) {
                j++;
                continue;
            }

            int intersectionStart = Math.max(intervalAStart, intervalBStart);
            int intersectionEnd = Math.min(intervalAEnd, intervalBEnd);
            result.add(new int[]{intersectionStart, intersectionEnd});

            if (intersectionEnd == intervalAEnd) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[0][0]);
    }
}
