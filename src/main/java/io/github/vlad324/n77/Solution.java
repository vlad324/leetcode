package io.github.vlad324.n77;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/combinations/"}
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        final var result = new ArrayList<List<Integer>>();
        combine(1, n, k, new ArrayList<>(k), result);
        return result;
    }

    private void combine(int start, int end, int count, List<Integer> current, List<List<Integer>> result) {
        if (count == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= end - count + 1; i++) {
            current.add(i);
            combine(i + 1, end, count - 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
