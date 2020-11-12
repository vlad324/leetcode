package io.github.vlad324.n47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/permutations-ii/"}
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final var counter = new HashMap<Integer, Integer>();
        for (final int n : nums) {
            counter.compute(n, (k, v) -> v == null ? 1 : v + 1);
        }

        final var combination = new LinkedList<Integer>();
        final var result = new ArrayList<List<Integer>>();
        dfs(combination, nums.length, counter, result);

        return result;
    }

    private void dfs(LinkedList<Integer> combination, int n, Map<Integer, Integer> counter, List<List<Integer>> result) {
        if (combination.size() == n) {
            result.add(new ArrayList<>(combination));
        }

        for (final var entry : counter.entrySet()) {
            final var number = entry.getKey();
            final var count = entry.getValue();

            if (count == 0) {
                continue;
            }

            combination.add(number);
            counter.put(number, count - 1);

            dfs(combination, n, counter, result);

            combination.removeLast();
            counter.put(number, count);
        }
    }
}
