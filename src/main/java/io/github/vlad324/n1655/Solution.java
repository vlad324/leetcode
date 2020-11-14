package io.github.vlad324.n1655;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link "https://leetcode.com/problems/distribute-repeating-integers/"}
 */
class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        final var map = new HashMap<Integer, Integer>();

        int max = 0;
        for (final var i : nums) {
            max = Math.max(map.compute(i, (k, v) -> v == null ? 1 : v + 1), max);
        }

        for (final var q : quantity) {
            if (q > max) {
                return false;
            }
        }

        Arrays.sort(quantity);

        return dfs(map, quantity, quantity.length - 1);
    }

    private boolean dfs(Map<Integer, Integer> counts, int[] quantity, int x) {
        if (x < 0) {
            return true;
        }

        final var currentQuantity = quantity[x];
        for (final var entry : counts.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (count >= currentQuantity) {
                counts.put(key, count - currentQuantity);
                if (dfs(counts, quantity, x - 1)) {
                    return true;
                }
                counts.put(key, count);
            }
        }

        return false;
    }
}
