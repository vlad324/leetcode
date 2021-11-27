package io.github.vlad324.n40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/combination-sum-ii/"}
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        final var result = new LinkedList<List<Integer>>();
        backtrack(candidates, target, 0, 0, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, int sum, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new LinkedList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            final var newSum = sum + candidates[i];
            if (newSum > target) {
                return;
            }

            combination.add(candidates[i]);
            backtrack(candidates, target, i + 1, newSum, combination, result);
            combination.removeLast();
        }
    }
}
