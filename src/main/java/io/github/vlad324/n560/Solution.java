package io.github.vlad324.n560;

import java.util.HashMap;

/**
 * {@link "https://leetcode.com/problems/subarray-sum-equals-k/"}
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        final var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (final int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
