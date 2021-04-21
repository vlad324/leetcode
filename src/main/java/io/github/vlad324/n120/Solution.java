package io.github.vlad324.n120;

import java.util.List;

/**
 * {@link "https://leetcode.com/problems/triangle/"}
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 1; i >= 0; i--) {
            final var item = triangle.get(i);
            for (int j = 0; j < item.size(); j++) {
                triangle.get(i).set(j, min(triangle, i, j) + item.get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    private int min(List<List<Integer>> triangle, int i, int j) {
        if (i + 1 == triangle.size()) {
            return 0;
        }

        final var row = triangle.get(i + 1);
        return Math.min(row.get(j), row.get(j + 1));
    }
}