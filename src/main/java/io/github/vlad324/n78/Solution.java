package io.github.vlad324.n78;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/subsets/"}
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        final var result = new LinkedList<List<Integer>>();
        result.add(new LinkedList<>());
        for (int num : nums) {
            final int size = result.size();
            for (int i = 0; i < size; i++) {
                final var subset = new LinkedList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }

        return result;
    }
}
