package io.github.vlad324.n41;

import java.util.HashSet;

/**
 * {@link "https://leetcode.com/problems/first-missing-positive/"}
 */
class Solution {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                final var index = nums[i] - 1;
                final var tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        final var seen = new HashSet<Integer>();

        for (final int num : nums) {
            if (num > 0) {
                seen.add(num);
            }
        }

        int i = 1;
        while (true) {
            if (!seen.contains(i)) {
                return i;
            }

            i++;
        }
    }
}
