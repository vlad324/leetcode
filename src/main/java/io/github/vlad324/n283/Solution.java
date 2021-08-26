package io.github.vlad324.n283;

/**
 * {@link "https://leetcode.com/problems/move-zeroes/"}
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int zIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zIndex == -1) {
                zIndex = i;
                continue;
            }

            if (nums[i] != 0 && zIndex != -1) {
                nums[zIndex] = nums[i];
                nums[i] = 0;
                zIndex++;
            }
        }
    }
}
