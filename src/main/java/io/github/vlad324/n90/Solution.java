package io.github.vlad324.n90;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link "https://leetcode.com/problems/subsets-ii/"}
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        final var valueToIndex = new HashMap<Integer, Integer>();
        final var result = new LinkedList<List<Integer>>();
        result.add(new LinkedList<>());
        for (var num : nums) {
            int end = result.size();
            int start = valueToIndex.getOrDefault(num, 0);
            for (int i = start; i < end; i++) {
                final var current = new LinkedList<>(result.get(i));
                current.add(num);
                result.add(current);
            }
            valueToIndex.put(num, end);
        }

        return result;
    }
}
