package io.github.vlad324.n56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * {@link "https://leetcode.com/problems/merge-intervals/"}
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        final var result = new ArrayList<int[]>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            final int[] interval = intervals[i];
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                result.add(current);
                current = interval;
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][2]);
    }
}
