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
}
