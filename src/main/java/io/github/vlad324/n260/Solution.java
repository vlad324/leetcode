package io.github.vlad324.n260;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/single-number-iii/"}
 */
class Solution {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Arrays.sort(nums);
        final var result = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                result[index++] = nums[i];
            } else {
                i++;
            }
        }

        if (index == 1) {
            result[index] = nums[nums.length - 1];
        }

        return result;
    }
}
