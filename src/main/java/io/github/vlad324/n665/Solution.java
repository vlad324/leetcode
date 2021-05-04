package io.github.vlad324.n665;

/**
 * {@link "https://leetcode.com/problems/non-decreasing-array/"}
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean changed = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (changed || (greater(nums, i - 2, i) && greater(nums, i - 1, i + 1))) {
                    return false;
                }
                changed = true;
            }
        }
        return true;
    }

    private boolean greater(int[] nums, int i, int j) {
        if (i < 0 || j == nums.length) {
            return false;
        }

        return nums[i] > nums[j];
    }
}
