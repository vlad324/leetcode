package io.github.vlad324.n35;

import java.util.Arrays;

/**
 * {@link "https://leetcode.com/problems/search-insert-position/"}
 */
class Solution {

    public int searchInsert(int[] nums, int target) {
        final var position = Arrays.binarySearch(nums, target);
        return position >= 0 ? position : Math.abs(position + 1);
    }

    public int searchInsert2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            int current = nums[m];
            if (current > target) {
                r = m - 1;
            } else if (current < target) {
                l = m + 1;
            } else {
                return m;
            }
        }

        return l;
    }
}
