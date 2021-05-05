package io.github.vlad324.n45;

/**
 * {@link "https://leetcode.com/problems/jump-game-ii/"}
 */
class Solution {

    private static final int IMPOSSIBLE = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        nums[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = IMPOSSIBLE;
            for (int j = Math.min(i + nums[i], nums.length - 1); j > i; j--) {
                min = Math.min(nums[j], min);
            }

            nums[i] = min == IMPOSSIBLE ? IMPOSSIBLE : min + 1;
        }

        return nums[0];
    }
}