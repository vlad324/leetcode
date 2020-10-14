package io.github.vlad324.n198;

/**
 * {@link "https://leetcode.com/problems/house-robber/"}
 */
class Solution {
    public int rob(int[] nums) {
        int prevNotRobed = 0;
        int prevRobed = 0;
        int max = 0;
        for (final int num : nums) {
            max = Math.max(prevNotRobed + num, prevRobed);
            prevNotRobed = prevRobed;
            prevRobed = max;
        }

        return max;
    }
}
