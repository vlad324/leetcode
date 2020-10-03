package io.github.vlad324.n485;

/**
 * {@link "https://leetcode.com/problems/max-consecutive-ones/"}
 */
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int currentSequence = 0;
        int maxSequence = 0;
        for (final int num : nums) {
            if (num == 1) {
                currentSequence++;
            } else {
                maxSequence = Math.max(maxSequence, currentSequence);
                currentSequence = 0;
            }
        }

        return Math.max(maxSequence, currentSequence);
    }
}
