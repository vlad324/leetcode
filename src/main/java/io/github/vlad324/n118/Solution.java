package io.github.vlad324.n118;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/pascals-triangle/"}
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        final var result = new ArrayList<List<Integer>>(numRows);
        result.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            final var n = i + 1;
            final var level = new ArrayList<Integer>(n);
            final var previous = result.get(i - 1);
            for (int j = 0; j < n; j++) {
                if (j == 0 || j == n - 1) {
                    level.add(1);
                } else {
                    level.add(previous.get(j) + previous.get(j - 1));
                }
            }
            result.add(level);
        }

        return result;
    }
}
