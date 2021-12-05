package io.github.vlad324.n45;

/**
 * {@link "https://leetcode.com/problems/jump-game-ii/"}
 */
class Solution {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int maxIndex = 0;
        int count = 0;
        int maxForCount = 0;
        for (int i = 0; i < nums.length; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1) {
                return count + 1;
            }
            if (i == maxForCount) {
                count++;
                maxForCount = maxIndex;
            }
        }

        return -1;
    }
}