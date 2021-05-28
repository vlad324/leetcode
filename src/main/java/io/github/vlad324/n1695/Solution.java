package io.github.vlad324.n1695;

import java.util.HashSet;

/**
 * {@link "https://leetcode.com/problems/maximum-erasure-value/"}
 */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        final var used = new HashSet<Integer>();

        int i = 0;
        int j = 0;
        int sum = 0;
        int max = 0;
        while (i < nums.length && j < nums.length) {
            if (!used.contains(nums[j])) {
                used.add(nums[j]);
                sum += nums[j];
                max = Math.max(max, sum);
                j++;
            } else {
                used.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }

        return max;
    }
}
