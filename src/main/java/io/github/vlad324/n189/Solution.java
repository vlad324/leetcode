package io.github.vlad324.n189;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/rotate-array/"}
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || (k = k % nums.length) == 0) {
            return;
        }

        final var temp = Arrays.copyOfRange(nums, nums.length - k, nums.length);

        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, temp.length);
    }
}