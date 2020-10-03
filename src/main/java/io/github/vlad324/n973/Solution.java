package io.github.vlad324.n973;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * {@link "https://leetcode.com/problems/k-closest-points-to-origin/"}
 */
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        final var set = new TreeSet<Point>();
        for (final var point : points) {
            set.add(new Point((point[0] * point[0]) + (point[1] * point[1]), point));
        }

        final var result = new int[k][];
        for (int i = 0; i < k && !set.isEmpty(); i++) {
            result[i] = set.pollFirst().coordinates;
        }


        return result;
    }

    private static class Point implements Comparable<Point> {
        public final int distanceSquare;
        public final int[] coordinates;

        public Point(int distanceSquare, int[] coordinates) {
            this.distanceSquare = distanceSquare;
            this.coordinates = coordinates;
        }

        @Override
        public int compareTo(Point o) {
            final var diff = Integer.compare(this.distanceSquare, o.distanceSquare);

            if (diff == 0) {
                return Arrays.compare(this.coordinates, o.coordinates);
            }

            return diff;
        }
    }
}
