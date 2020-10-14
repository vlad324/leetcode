package io.github.vlad324.n213;

/**
 * {@link "https://leetcode.com/problems/house-robber-ii/"}
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {
        int prevNotRobed = 0;
        int prevRobed = 0;
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(prevNotRobed + nums[i], prevRobed);
            prevNotRobed = prevRobed;
            prevRobed = max;
        }

        return max;
    }
}

