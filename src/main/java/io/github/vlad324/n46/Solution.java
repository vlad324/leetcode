package io.github.vlad324.n46;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/permutations/"}
 */
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        final var result = new ArrayList<List<Integer>>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);

                permute(nums, used, current, result);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
