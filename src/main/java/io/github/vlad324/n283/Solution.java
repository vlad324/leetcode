package io.github.vlad324.n283;

import java.util.ArrayDeque;

/**
 * {@link "https://leetcode.com/problems/move-zeroes/"}
 */
class Solution {
    public void moveZeroes(int[] nums) {
        final var zeroIndexes = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndexes.add(i);
            } else if (!zeroIndexes.isEmpty()) {
                nums[zeroIndexes.poll()] = nums[i];
                nums[i] = 0;
                zeroIndexes.add(i);
            }
        }
    }
}
