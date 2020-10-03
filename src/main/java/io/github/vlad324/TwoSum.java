package io.github.vlad324;

import java.util.HashMap;

/**
 * {@link "https://leetcode.com/problems/two-sum/"}
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        final var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            final var diff = target - nums[i];
            final Integer index;
            if ((index = map.get(diff)) != null) {
                return new int[]{index, i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }
}
