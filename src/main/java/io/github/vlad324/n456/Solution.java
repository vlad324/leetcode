package io.github.vlad324.n456;

/**
 * {@link "https://leetcode.com/problems/132-pattern/"}
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            final int first = nums[i];
            int middle = first;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > middle) {
                    middle = nums[j];
                } else if (nums[j] > first && nums[j] < middle) {
                    return true;
                }
            }
        }

        return false;
    }
}