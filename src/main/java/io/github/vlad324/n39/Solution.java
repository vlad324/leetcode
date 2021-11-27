package io.github.vlad324.n39;

import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/combination-sum/"}
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final var result = new LinkedList<List<Integer>>();
        backtrack(candidates, target, 0, 0, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, int sum, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new LinkedList<>(combination));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target, i, sum + candidates[i], combination, result);
            combination.removeLast();
        }
    }
}
