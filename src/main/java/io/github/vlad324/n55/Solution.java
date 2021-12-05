package io.github.vlad324.n55;

/**
 * {@link "https://leetcode.com/problems/jump-game/"}
 */
class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // if it can jump from this index to the last
            if (i + nums[i] >= last) {
                last = i;
            }
        }

        return last == 0;
    }
}
