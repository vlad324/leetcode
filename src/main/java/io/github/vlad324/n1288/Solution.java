package io.github.vlad324.n1288;

/**
 * {@link "https://leetcode.com/problems/remove-covered-intervals/"}
 */
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i] == null) {
                continue;
            }

            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j] == null) {
                    continue;
                }

                if (isCovered(intervals[i], intervals[j])) {
                    count--;
                    break;
                }

                if (isCovered(intervals[j], intervals[i])) {
                    intervals[j] = null;
                    count--;
                }
            }
        }

        return count;
    }

    private boolean isCovered(int[] check, int[] cover) {
        return check[0] >= cover[0] && check[1] <= cover[1];
    }
}
