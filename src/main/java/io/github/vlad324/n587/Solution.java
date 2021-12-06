package io.github.vlad324.n587;

import java.util.HashSet;

/**
 * {@link "https://leetcode.com/problems/erect-the-fence/"}
 */
class Solution {
    public int[][] outerTrees(int[][] points) {
        if (points.length < 4) {
            return points;
        }

        final var hull = new HashSet<int[]>();
        int leftMostIndex = 0;
        for (int i = 0; i < points.length; i++)
            if (points[i][0] < points[leftMostIndex][0]) {
                leftMostIndex = i;
            }

        int p = leftMostIndex;
        do {
            int q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }

            for (int i = 0; i < points.length; i++) {
                if (i != p && i != q &&
                    orientation(points[p], points[i], points[q]) == 0 &&
                    inBetween(points[p], points[i], points[q])) {
                    hull.add(points[i]);
                }
            }

            hull.add(points[q]);
            p = q;
        }
        while (p != leftMostIndex);

        return hull.toArray(new int[hull.size()][]);
    }

    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    private boolean inBetween(int[] p, int[] i, int[] q) {
        final var a = (i[0] >= p[0] && i[0] <= q[0]) || (i[0] <= p[0] && i[0] >= q[0]);
        final var b = (i[1] >= p[1] && i[1] <= q[1]) || (i[1] <= p[1] && i[1] >= q[1]);

        return a && b;
    }
}
