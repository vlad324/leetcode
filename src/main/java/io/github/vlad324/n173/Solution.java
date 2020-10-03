package io.github.vlad324.n173;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/single-number-ii/"}
 */
class Solution {

    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        int i = 0;
        while (i + 2 < nums.length) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }

            if (nums[i] != nums[i + 2]) {
                return nums[i + 2];
            }
            i += 3;
        }

        return nums[nums.length - 1];
    }
}
