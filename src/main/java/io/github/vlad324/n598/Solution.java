package io.github.vlad324.n598;

/**
 * {@link "https://leetcode.com/problems/range-addition-ii/"}
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int xMin = m;
        int yMin = n;
        for (final var op : ops) {
            xMin = Math.min(xMin, op[0]);
            yMin = Math.min(yMin, op[1]);
        }

        return xMin * yMin;
    }
}
